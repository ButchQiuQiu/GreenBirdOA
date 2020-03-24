package com.bdqn.model.actionbiz.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bdqn.controller.Action;
import com.bdqn.model.data.bean.User;
import com.bdqn.model.data.dao.UserDao;
import com.bdqn.model.data.dao.impl.UserDaoImpl;

import net.sf.json.JSONObject;

public class InitLoginAction extends InitLogin implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse rep) {
			PrintWriter writer;
			try {
				writer = rep.getWriter();
				HttpSession session= req.getSession(false);
				if(session.getAttribute("user")!=null) {					
					UserDao ud=new UserDaoImpl();
					User user=ud.GetUserByUser(session.getAttribute("user").toString());
					this.returnIsTrue=true;
					this.userName=user.getName();
					this.userDepart=user.getFk_depart().getName();
				}else {
					this.returnIsTrue=false;
				}
				JSONObject jobject=JSONObject.fromObject("{'returnIsTrue':'"+this.returnIsTrue+"',userName:'"+this.userName+"',userDepart:'"+this.userDepart+"'}");
				System.out.println(jobject.toString());
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
