package com.bdqn.test;

import net.sf.json.JSONObject;

public class test {
	public static void main(String[] args) {
		JSONObject jobject=JSONObject.fromObject("{'returnIsTrue':'"+true+"'}");
		System.out.println(jobject.toString());
		//
		
	}
}
