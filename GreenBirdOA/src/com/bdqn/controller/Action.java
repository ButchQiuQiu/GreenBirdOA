package com.bdqn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	public String execute(HttpServletRequest req,HttpServletResponse rep) ;
}
