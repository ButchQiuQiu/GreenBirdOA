package com.bdqn.model.actionbiz.signin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bdqn.model.data.dao.UserDao;
import com.bdqn.model.data.dao.impl.UserDaoImpl;

import net.sf.json.JSONObject;

public class SigninAction extends Signin {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse rep) {
		try {
			PrintWriter writer; writer = rep.getWriter();
			HttpSession session= req.getSession();
			UserDao ud=new UserDaoImpl();
			if(ud.SetSignin(session.getAttribute("user").toString())) {
				this.returnIsTrue=true;
			}else {
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
