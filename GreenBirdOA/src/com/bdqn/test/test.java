package com.bdqn.test;

import net.sf.json.JSONObject;

public class test {
	public static void main(String[] args) {
		
		String value="fk_sdfusersdfsdfsdfsd_sent";
		String str=value.substring(3, (value.substring(3, value.length())).indexOf("_")+3);
		System.out.println(str);
		//
		
	}
}
