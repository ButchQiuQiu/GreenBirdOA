package com.bdqn.model.actionbiz.manage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bdqn.model.data.bean.Depart;
import com.bdqn.model.data.bean.Jurisdiction;
import com.bdqn.model.data.bean.Sex;
import com.bdqn.model.data.bean.User;
import com.bdqn.model.data.dao.UserDao;
import com.bdqn.model.data.dao.impl.UserDaoImpl;

import net.sf.json.JSONObject;

public class AddUserAction extends AddUser {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse rep) {
//		Enumeration enu = req.getParameterNames();
		Map<String, String[]> userFiled=req.getParameterMap();
//		while (enu.hasMoreElements()) {
//			String paraName = (String) enu.nextElement();
//			System.out.println(paraName + ": " + req.getParameter(paraName));
//		}
		
		User user = new User();
		
		user.setName(userFiled.get("name")[0]);
		user.setUser(req.getParameter("user"));
		user.setPwd(userFiled.get("pwd")[0]);
		Sex sex=new Sex(); sex.setId(Integer.parseInt(userFiled.get("fk_sex")[0]));
		user.setFk_sex(sex);
		user.setAddress(userFiled.get("address")[0]);
		user.setPhone(userFiled.get("phone")[0]);
		user.setLastsign(userFiled.get("lastsign")[0]);
		user.setAbsenteeism(Integer.parseInt(userFiled.get("absenteeism")[0]));
		user.setSalary(Double.parseDouble(userFiled.get("salary")[0]));
		Depart depart=new Depart();depart.setId(Integer.parseInt(userFiled.get("fk_depart")[0]));
		user.setFk_depart(depart);
		Jurisdiction jurisdiction=new Jurisdiction();jurisdiction.setId(Integer.parseInt(userFiled.get("fk_jurisdiction")[0]));
		user.setFk_jurisdiction(jurisdiction);
		UserDao ud=new UserDaoImpl();
		User useUser=ud.GetUserByUser(req.getSession().getAttribute("user").toString());
		//部门判定,必须是可以修改的部门
		if("人事部".equals(useUser.getFk_depart().getName())||"管理层".equals(useUser.getFk_depart().getName())) {
			//权限判定,自己的权限必须得大于或者等于添加的用户
			if(useUser.getFk_jurisdiction().getId()>=user.getFk_jurisdiction().getId()) {
				this.returnIsTrue=ud.addUser(user);
			}
		}
		try {
			PrintWriter writer = rep.getWriter();
			JSONObject jobject=JSONObject.fromObject(
					"{'returnIsTrue':'"+this.returnIsTrue+"'}");
			writer.write(jobject.toString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
