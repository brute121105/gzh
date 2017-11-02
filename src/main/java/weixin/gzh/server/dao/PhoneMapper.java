package weixin.gzh.server.dao;

import java.io.Serializable;
import java.util.List;

import weixin.gzh.server.model.PhoneTest;
import weixin.gzh.server.persistence.BaseDao;



public interface PhoneMapper extends BaseDao<PhoneTest, Serializable>{
	
	List<PhoneTest> findByText(PhoneTest pt);
	
	void saveReq(PhoneTest pt);

}
