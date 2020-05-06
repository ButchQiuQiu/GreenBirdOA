package com.bdqn.model.data.dao.impl;

import java.util.List;

import com.bdqn.model.data.bean.Jurisdiction;
import com.bdqn.model.data.dao.JurisdictionDao;
import com.bdqn.model.data.util.BaseImpl;

public class JurisdictionDaoImpl extends BaseImpl<Jurisdiction> implements JurisdictionDao {

	@Override
	public List<Jurisdiction> getAllJurisdiction() {
		return this.ExecuteQueryBySql(Jurisdiction.class,"select * from "+Jurisdiction.tablename);
	}

}
