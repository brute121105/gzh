package weixin.gzh.server.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import weixin.gzh.server.dao.PhoneMapper;
import weixin.gzh.server.model.PhoneTest;
import weixin.gzh.server.service.CoreService;
import weixin.gzh.server.util.SignUtil;




@RestController
public class HttpTest {
	final Log log=LogFactory.getLog(HttpTest.class);
	
	
	@Autowired
	PhoneMapper dao;
	
	@RequestMapping(value = "/testDB", method = RequestMethod.GET)
	public Object t2() {
		log.info("test--weixin--gongzonghao----");
		List<PhoneTest> pt = dao.findAll();
		log.info("pt-->"+JSON.toJSONString(pt));
		return pt;
	}
	

}
