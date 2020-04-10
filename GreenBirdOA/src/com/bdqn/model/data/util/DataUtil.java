package com.bdqn.model.data.util;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mchange.v2.c3p0.ComboPooledDataSource;


//不用创建实例的静态工具类 包括底层数据操作
public final class DataUtil {
//连接池--------------------------------------------------------------------------------------------------
	//启动c3p0连接池
	private static ComboPooledDataSource dataSource=new ComboPooledDataSource("mysql");
	//返回连接池分配的Connection
		public static Connection getConnection()  {
			try {
				Connection con=DataUtil.dataSource.getConnection();
//				System.out.println("最大连接数"+DataUtil.dataSource.getMaxPoolSize()+"最小连接数"+DataUtil.dataSource.getMinPoolSize()+
//				"正在使用连接数"+DataUtil.dataSource.getNumBusyConnections()+"空闲连接数"+DataUtil.dataSource.getNumIdleConnections()+
//				"总连接数"+DataUtil.dataSource.getNumConnections());
				return con;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		//断开连接
		public static void closeConnection(Connection con,PreparedStatement pstm,ResultSet rs) throws Exception {
			if(con!=null) {
				con.close();
			}
			if(pstm!=null) {
				pstm.close();
			}
			if(rs!=null) {
				rs.close();
			}
		}
//连接池--------------------------------------------------------------------------------------------------
	
/** 自己封装的简陋jdbc
 * 
		public static String ConStr="jdbc:mysql://localhost:3306/greenbirdoa?characterEncoding=utf-8",
		  User="root",
		  Pwd="199598";
	
	//连接程序默认的数据库
	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=null;
		con=DriverManager.getConnection(DataUtil.ConStr,DataUtil.User,DataUtil.Pwd);
		return con;
	}
	
	//断开连接
	public static void closeConnection(Connection con,PreparedStatement pstm,ResultSet rs) throws Exception {
		if(con!=null) {
			con.close();
		}
		if(pstm!=null) {
			pstm.close();
		}
		if(rs!=null) {
			rs.close();
		}
	}
*/
		
//自己搓的类Dbuntil框架可以组合成一个通用Impl类来减少代码的重复量------------------------------------------------
//通用类仅为静态函数,多实例也不会浪费内存.
		
	//sql查询  按照Field集合返回一个已经进行数据赋值封装后的实体类集合  参数:sql,占位对象集,反射类
	//表中外键已经能迭代计算,表中的外键格式为:fk_外键表名_可有可无,第2个下划线后之后的可有可无主要应对表中2个外键字段来自一张表
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static <T>List<T> ExecuteQueryBySql(Class<?> cs,String sql,Object... values) throws Exception {
		List<T> beans=new ArrayList<T>();
		Field fields[]=cs.getDeclaredFields();
		Connection con=DataUtil.getConnection();
		PreparedStatement pstm=con.prepareStatement(sql);
		if(values!=null) {
			for(int k=1;k<=values.length;k++) {
				pstm.setObject(k, values[k-1]);
			}
		}
		ResultSet rs=pstm.executeQuery();
		while(rs.next()) {
			Object bean=cs.newInstance();
			for(int i=0;i<fields.length;i++) {
				//掠过tablename和没有数据的属性成员
				String fieldName=fields[i].getName();
				if(fieldName.equals("tablename")||(IsColumnExist(rs.getMetaData(),fieldName)==false&&fieldName.indexOf("fk_")==-1)) {continue;}
				//取出表中和属性名相同名称的字段值
				Object data=null; 							
				//判断这个属性是否为外键对象,是就迭代读取外键表转为对象保存进数据,否就保存就正常保存数据
				if(fieldName.indexOf("fk_")==0) {
					data=rs.getObject(fieldName);
					//利用反射获取外键类对应的类名(如果不止一个下划线那么外键类名是第一个下划线到第二个下划线的中间字符串)
					String fkClassName=fieldName.substring(3, fieldName.length());
					//如果多一个_就表示多出来的是外键字段名,减去它就是外键类名了
					if(fkClassName.indexOf("_")!=-1) {
						fkClassName=fkClassName.substring(0,fkClassName.indexOf('_'));
					}
					//把fkClassName变成带包名的类名全称
					fkClassName=cs.getPackage().getName()+"."+fkClassName.substring(0,1).toUpperCase()+fkClassName.substring(1);
					//利用反射获取外键类对应的表名
					String fkTableName=(String)Class.forName(fkClassName).getField("tablename").get(null);
					//迭代计算出这外键表对象
					data=ExecuteQueryBySql(Class.forName(fkClassName),"select * from "+fkTableName+" where id=?",data).get(0);
				}else {
					//正常读取保存数据
					data=rs.getObject(fieldName);
				}
				//调用封装函数封装属性
				DataUtil.invokeByMethodName(
						DataUtil.GetSetMethodNameForEclipseEncap(fieldName), 	//反射方法名--加工为包装set函数
						data,													//反射方法的参数
						bean													//指定反射的对象
				);
			}
			//把实体类加入进集合
			beans.add((T) bean);
		}
		DataUtil.closeConnection(con, pstm, rs);
		return beans;
	}
	
	// 增删改
	public static int ExcuteUpdateBySql(String sql,Object... values) throws Exception {
		Connection con=DataUtil.getConnection();
		PreparedStatement pstm= con.prepareStatement(sql);
		if(values!=null) {
			for(int k=1;k<=values.length;k++) {
				pstm.setObject(k, values[k-1]);
			}
		}
		int re=pstm.executeUpdate();
		DataUtil.closeConnection(con, pstm, null);
		return re;
	}
	
	//判断是否有此列
	public static boolean IsColumnExist(ResultSetMetaData md,String columnname) throws Exception {
		for(int i=0;i<md.getColumnCount();i++) {
			if(md.getColumnName(i+1).equals(columnname)) {
				return true;
			};
		}
		return false;
	}
	
	//反射
	//获取实体类的所有属性名(去除tablename 需要传入实现类的superclass())
	@SuppressWarnings({ "rawtypes", "unused", "deprecation" })
	public static ArrayList<String> GetAllFields(Class cs){
		ArrayList<String> beanmethods=new ArrayList<String>(); 
		try {
			Object bean=cs.newInstance(); //创建一个实例
			Field[] fields= cs.getDeclaredFields();
			for(Field fieldtemp:fields) {
				if(fieldtemp.getName().equals("tablename")==false) {
					beanmethods.add(fieldtemp.getName());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return beanmethods;
	}
	
	//把传入的属性名转换为eclipse的默认封装名 Get
	public static String  GetGetMethodNameForEclipseEncap(String fieldname) {
		char[] temp=fieldname.toCharArray();
		temp[0]=Character.toUpperCase(temp[0]);
		return "get"+new String(temp);
	}
	
	//把传入的属性名转换为eclipse的默认封装名 Set
	public static String GetSetMethodNameForEclipseEncap(String fieldname) {
		char[] temp=fieldname.toCharArray();
		temp[0]=Character.toUpperCase(temp[0]);
		return "set"+new String(temp);
	}
	
	//使用class的某个函数 仅传入一个data参数 参数:方法名,参数,传参bean
	public static Object invokeByMethodName(String MethodName,Object data,Object bean) {
		try {
			Method method=bean.getClass().getDeclaredMethod(MethodName,data.getClass());
			method.invoke(bean,data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return bean;
	}
}
