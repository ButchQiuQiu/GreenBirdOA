package com.bdqn.model.actionbiz.global;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
	
/**
 * Application Lifecycle Listener implementation class SigninListene
 * 
 *	服务器启动时会把签到检查的时间设为当天的凌晨23-59-59;
 * 服务器启动时启动一个线程,此线程每过一会儿就会检查时间,时间过了晚上12点就会扫描所有人的签到
 *
 */

public class SigninListener implements ServletContextListener {
	private static AllSigninThread as;
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    @SuppressWarnings("deprecation")
	public void contextDestroyed(ServletContextEvent sce)  { 
    	as.stop();
    	System.out.println("服务器销毁");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	as=new AllSigninThread();
    	as.start();
    	System.out.println("服务器启动,启动签到全局线程");
    }
	
}
