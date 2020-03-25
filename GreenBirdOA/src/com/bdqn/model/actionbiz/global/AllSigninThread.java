package com.bdqn.model.actionbiz.global;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.bdqn.model.data.dao.UserDao;
import com.bdqn.model.data.dao.impl.UserDaoImpl;

/**
 * @author QiuQiu
 * 
 * //签到检查线程
 *
 */
public class AllSigninThread extends Thread{
	private static String checkAllSign=new SimpleDateFormat("yyyy-MM-dd").format(new Date())+" 23-59-59";
	
	@Override
	public void run() {
		super.run();
		while(true) {
			try {
				Thread.sleep(3000);
				SimpleDateFormat ft= new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
				//当前时间是否超过签到检查时间
				if(new Date().compareTo(ft.parse(checkAllSign))==1) {
					UserDao ud=new UserDaoImpl();
					ud.setAllSign();
					//完成签到换算后休眠1500毫秒以免计算太快时间还是前一天,然后重新计算下次签到点
					Thread.sleep(1500);
					AllSigninThread.checkAllSign=new SimpleDateFormat("yyyy-MM-dd").format(new Date())+" 23-59-59";
					//
				}else {
					System.out.println("检测时间,当前时间是"+ft.format(new Date()));
					System.out.println("下一个签到检查点的时间是:"+AllSigninThread.checkAllSign);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
