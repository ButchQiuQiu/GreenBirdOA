package com.bdqn.model.data.dao.impl;

import java.util.List;

import com.bdqn.model.data.bean.Sex;
import com.bdqn.model.data.dao.SexDao;
import com.bdqn.model.data.util.BaseImpl;

public class SexDaoImpl extends BaseImpl<Sex> implements SexDao {

	@Override
	public List<Sex> getAllSex() {
		// TODO Auto-generated method stub
		return this.ExecuteQueryBySql(Sex.class,"select * from "+Sex.tablename);
	}

}
