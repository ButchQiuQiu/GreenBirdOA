package com.bdqn.data.util;

import java.util.List;

//所有接口的父类 有2个通用方法 如果某张表需求独特的功能就写在对应的接口上 
public interface BaseDao<T>{
	//查
	public List<T>  ExecuteQueryBySql(Class<T> cs,String sql,Object... values);
	//增删改
	public boolean ExecuteUpdateBySql(String sql,Object... values);
}
