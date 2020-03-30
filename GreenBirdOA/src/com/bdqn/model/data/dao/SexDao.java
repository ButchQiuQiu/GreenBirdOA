package com.bdqn.model.data.dao;

import java.util.List;

import com.bdqn.model.data.bean.Sex;
import com.bdqn.model.data.util.BaseDao;

public interface SexDao extends BaseDao<Sex> {

	List<Sex> getAllSex();

}
