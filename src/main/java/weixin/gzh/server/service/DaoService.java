package weixin.gzh.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import weixin.gzh.server.dao.PhoneMapper;
import weixin.gzh.server.model.PhoneTest;

@Repository
public class DaoService {
	
	@Autowired
	PhoneMapper dao;
	
	public List<PhoneTest> findList() {
		List<PhoneTest>  pt = dao.findAll();
		return pt;
	}

}
