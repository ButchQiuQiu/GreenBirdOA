package com.bdqn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path=request.getServletPath();
		System.out.println(path);
		path=path.substring(path.lastIndexOf("/")+1, path.length()-3);
		String className=path.substring(0, 1)+path.substring(1);
		//利用反射映射到指定的action 
		className=("com.bdqn.model.actionbiz."+className+"Action").replace('_', '.');
		try {
			@SuppressWarnings("rawtypes")
			Class clazz=Class.forName(className);
			@SuppressWarnings("deprecation")
			Action action=(Action)clazz.newInstance();
			String toPath=action.execute(request, response);
			if(toPath!=null) {
				request.getRequestDispatcher(toPath).forward(request, response);
			} 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
