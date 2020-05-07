package com.bdqn.model.actionbiz.manage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.model.data.bean.User;
import com.bdqn.model.data.dao.UserDao;
import com.bdqn.model.data.dao.impl.UserDaoImpl;

import net.sf.json.JSONObject;

public class EditUserAction extends EditUser {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse rep) {
		UserDao ud=new UserDaoImpl();
		User user=ud.GetUserByUser(req.getSession().getAttribute("user").toString());
		//部门判定
		if("人事部".equals(user.getFk_depart().getName())||"管理层".equals(user.getFk_depart().getName())) {
			//权限判定,自己的权限必须得大于或者等于修改的用户
			if(user.getFk_jurisdiction().getId()>=ud.GetUserByUser(req.getParameter("user")).getFk_jurisdiction().getId()) {
				//修改权限判定,如果修改的是权限那么权限必须小于发起者的权限
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
