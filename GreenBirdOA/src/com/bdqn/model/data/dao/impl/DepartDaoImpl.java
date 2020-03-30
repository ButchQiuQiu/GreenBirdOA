package com.bdqn.model.data.dao.impl;

import java.util.List;

import com.bdqn.model.data.bean.Depart;
import com.bdqn.model.data.dao.DepartDao;
import com.bdqn.model.data.util.BaseImpl;

public class DepartDaoImpl extends BaseImpl<Depart> implements DepartDao {

	@Override
	public List<Depart> getAllDepart() {
		// TODO Auto-generated method stub
		return this.ExecuteQueryBySql(Depart.class,"select * from "+Depart.tablename);
	}

}
