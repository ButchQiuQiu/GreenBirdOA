package com.bdqn.data.util;

import java.util.List;
//数据通用类 继承dao通用接口 所有daoimpl都会继承他 
//每添加一张表只需要实体类继承bean 对应的dao接口只需要写独特需求的函数 对应的impl只需要继承实体类实现对应dao接口的独特需求方法
public abstract class BaseImpl<T> implements BaseDao<T> {
	public BaseImpl() {};
	
	//查询
	public List<T> ExecuteQueryBySql(Class<T> cs,String sql,Object... values){
		try {
			return DataUtil.ExecuteQueryBySql(cs,sql,values);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//不用填入Class<T> cs 的查询 会增加5毫秒的开销(intel的4ghz的cpu)  重写代码为：return super.ExecuteQueryBySql(new GenericUtil<User>() {}.getTClass(), sql, values);
	//只有子类重写才能用否则报错
//	public abstract  List<T> ExecuteQueryBySql(String sql,Object... values);
	
	//删改
	public boolean ExecuteUpdateBySql(String sql,Object... valuse) {
		try {
			if(DataUtil.ExcuteUpdateBySql(sql,valuse)!=0) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}

