package com.bdqn.model.data.dao;

import java.util.List;

import com.bdqn.model.data.bean.Jurisdiction;
import com.bdqn.model.data.util.BaseDao;

public interface JurisdictionDao extends BaseDao<Jurisdiction> {
	List<Jurisdiction> getAllJurisdiction();
}
