package weixin.gzh.server.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import weixin.gzh.server.dao.PhoneMapper;
import weixin.gzh.server.model.PhoneTest;
import weixin.gzh.server.service.CoreService;
import weixin.gzh.server.service.DaoService;
import weixin.gzh.server.util.DateTimeUtil;
import weixin.gzh.server.util.SignUtil;




@RestController
public class HttpTest {
	final Log log=LogFactory.getLog(HttpTest.class);
	
	
	@Autowired
	PhoneMapper dao;
	
	@Autowired
	DaoService daoService;
	
	@RequestMapping(value = "/testDB", method = RequestMethod.GET)
	public Object t2() {
		log.info("test--weixin--gongzonghao----");
		List<PhoneTest> pt = dao.findAll();
		for(PhoneTest p:pt) {
			System.out.println(p.getId()+"--"+DateTimeUtil.formatDate(p.getCreate_time()));
		}
		log.info("pt-->"+JSON.toJSONString(pt));
		return pt;
	}
	@RequestMapping(value = "/testDBLike", method = RequestMethod.GET)
	public Object testDBLike() throws ParseException {
		log.info("test--weixin--testDBLike----");


		
		PhoneTest qc = new PhoneTest();
		qc.setCreate_time(DateTimeUtil.getCurrentZeroDate());
		qc.setText("%南宁%");
		List<PhoneTest> pt = dao.findByText(qc);
		log.info("pt-->"+JSON.toJSONString(pt));
		return pt;
	}
	
	@RequestMapping(value = "/testDBQC", method = RequestMethod.GET)
	public Object testDBQC() throws ParseException {
		/*Map<String,Object> params = new HashMap<String,Object>();
		params.put("text", "%北通%");
		params.put("today", DateTimeUtil.getCurrentZeroDate());
		params.put("lastDay",DateTimeUtil.getLastDate());
		List<PhoneTest> pt = dao.findListByMap(params);
		log.info("pt-->"+JSON.toJSONString(pt));*/
		System.out.println(daoService.createResMsg("北通","1","2"));
		return null;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public Object save() {
		log.info("test--weixin--insert----");
		PhoneTest pt = new PhoneTest();
		pt.setText("dd");
		pt.setCreate_time(new Date());
		dao.save(pt);
		log.info("pt-->"+JSON.toJSONString(pt));
		return pt;
	}
	

}
