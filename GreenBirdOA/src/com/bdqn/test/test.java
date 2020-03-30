package com.bdqn.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class test {
	public static void main(String[] args) throws ParseException {
		 Date dNow = new Date( );
	      SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH-mm-ss");
	      SimpleDateFormat ft2=new SimpleDateFormat("yyyy-MM-dd");
	      
	      
	      System.out.println(ft.parse("2019-01-01 01-01-01").compareTo(ft.parse(ft2.format(dNow)+" 01-01-02")));
	}
}
