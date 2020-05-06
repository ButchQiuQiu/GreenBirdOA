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
			
			try {
				PrintWriter writer = rep.getWriter();
				HttpSession session= req.getSession(false);
				if(session!=null&&session.getAttribute("user")!=null) {					
					UserDao ud=new UserDaoImpl();
					User user=ud.GetUserByUser(session.getAttribute("user").toString());
					this.returnIsTrue=true;
					this.userName=user.getName();
					this.userDepart=user.getFk_depart().getName();
					this.userToDayIsSignin="未签到".equals(user.getLastsign())?false:true;
				}else {
					this.returnIsTrue=false;
				}
				JSONObject jobject=JSONObject.fromObject(
						"{'returnIsTrue':'"+this.returnIsTrue+"',userName:'"+this.userName+"',userDepart:'"+this.userDepart+"',userToDayIsSignin:'"+this.userToDayIsSignin+"'}");
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
