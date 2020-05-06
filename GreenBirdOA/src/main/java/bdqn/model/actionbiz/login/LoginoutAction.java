package com.bdqn.model.actionbiz.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginoutAction extends Loginout {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse rep) {
		req.getSession().removeAttribute("user");
		return null;
	}

}
