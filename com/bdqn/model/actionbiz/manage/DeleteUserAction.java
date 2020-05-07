package com.bdqn.model.actionbiz.manage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.model.data.bean.User;
import com.bdqn.model.data.dao.UserDao;
import com.bdqn.model.data.dao.impl.UserDaoImpl;

import net.sf.json.JSONObject;

public class DeleteUserAction extends DeleteUser {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse rep) {
		UserDao ud=new UserDaoImpl();
		User user=ud.GetUserByUser(req.getSession().getAttribute("user").toString());
		if("人事部".equals(user.getFk_depart().getName())||"管理层".equals(user.getFk_depart().getName())) {
			//不能删除自己
			if(user.getUser().equals(req.getParameter("user"))==false) {
				this.returnIsTrue=ud.deleteUser(req.getParameter("user"));
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
