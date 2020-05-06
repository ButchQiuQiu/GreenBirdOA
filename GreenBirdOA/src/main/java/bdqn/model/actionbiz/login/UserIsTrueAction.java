package com.bdqn.model.actionbiz.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.model.data.dao.UserDao;
import com.bdqn.model.data.dao.impl.UserDaoImpl;

import net.sf.json.JSONObject;

public class UserIsTrueAction extends UserIsTrue{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse rep) {	
		try {
			PrintWriter writer=rep.getWriter();
			this.user=req.getParameter("user");
			this.pwd=req.getParameter("pwd");
			UserDao ud=new UserDaoImpl();
			//验证登录成功就把user存储到session
			if(ud.LoginIsTrue(this.user,this.pwd)) {
				this.returnIsTrue=true;
				//存储user
				req.getSession().setAttribute("user", user);
			}else{
				this.returnIsTrue=false;
			}
			JSONObject jobject=JSONObject.fromObject("{'returnIsTrue':'"+this.returnIsTrue+"'}");
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
