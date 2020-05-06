package bdqn.model.data.dao;

import java.util.List;

import bdqn.model.data.util.BaseDao;

public interface SexDao extends BaseDao<Sex> {

	List<Sex> getAllSex();

}
