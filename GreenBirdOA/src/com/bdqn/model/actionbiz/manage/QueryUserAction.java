package com.bdqn.model.actionbiz.manage;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bdqn.model.data.bean.Depart;
import com.bdqn.model.data.bean.Jurisdiction;
import com.bdqn.model.data.bean.Sex;
import com.bdqn.model.data.bean.User;
import com.bdqn.model.data.dao.DepartDao;
import com.bdqn.model.data.dao.JurisdictionDao;
import com.bdqn.model.data.dao.SexDao;
import com.bdqn.model.data.dao.UserDao;
import com.bdqn.model.data.dao.impl.DepartDaoImpl;
import com.bdqn.model.data.dao.impl.JurisdictionDaoImpl;
import com.bdqn.model.data.dao.impl.SexDaoImpl;
import com.bdqn.model.data.dao.impl.UserDaoImpl;

import net.sf.json.JSONArray;

public class QueryUserAction extends QueryUser {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse rep) {
		HttpSession session=req.getSession(false);
		//用户是否登录
		if(session==null||session.getAttribute("user")==null) {
			return null;
		}
		//按照用户的权限和部门返回相对权限查询语句
		String sql="select * from "+User.tablename+" where ";
		UserDao ud=new UserDaoImpl();
		User user=ud.GetUserByUser(session.getAttribute("user").toString());
		//给每种级别的用户加上where限定词
		switch (user.getFk_depart().getName()) {
		//可查看权限小于自己的用户
		case "人事部":
			sql+="user='"+user.getUser()+"' or fk_jurisdiction<"+user.getFk_jurisdiction().getId();
			break;
		//和人事部一样
		case "管理层":
			sql+="user='"+user.getUser()+"' or fk_jurisdiction<"+user.getFk_jurisdiction().getId();
			break;
		//其他用户只可以查看自己或者权限小于自己的同部门用户
		default:
			sql+="user='"+user.getUser()+"' or (fk_jurisdiction<"+user.getFk_jurisdiction().getId()+" and fk_depart="+user.getFk_depart().getId()+")";
			break;
		}
		System.out.println(sql);
		
		//传输json数组
		List<User> users=ud.getAllUser(sql);
		JSONArray jsons=new JSONArray();
		//坐标0是sex集合
		SexDao sd=new SexDaoImpl();
		List<Sex> sexs=sd.getAllSex();
		jsons.add(sexs);
		//坐标1是depart集合
		DepartDao dd=new DepartDaoImpl();
		List<Depart> departs=dd.getAllDepart();
		jsons.add(departs);
		//坐标2是jurisdiction集合
		JurisdictionDao jd =new JurisdictionDaoImpl();
		List<Jurisdiction> jurs=jd.getAllJurisdiction();
		jsons.add(jurs);
		try {
			PrintWriter writer=rep.getWriter();
			for(User userTemp:users) {
				jsons.add(userTemp);
			}
			writer.write(jsons.toString());
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
