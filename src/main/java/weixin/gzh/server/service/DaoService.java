package weixin.gzh.server.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;

import weixin.gzh.server.conf.DomainConf;
import weixin.gzh.server.dao.PhoneMapper;
import weixin.gzh.server.model.PhoneTest;
import weixin.gzh.server.util.DateTimeUtil;

@Repository
public class DaoService {
	private static Logger log = LoggerFactory.getLogger(DaoService.class);
	
	@Autowired
	PhoneMapper dao;
	
	public List<PhoneTest> findList() {
		List<PhoneTest>  pt = dao.findAll();
		return pt;
	}
	public List<PhoneTest> findByText(PhoneTest phoneTest) {
		List<PhoneTest>  pt = dao.findByText(phoneTest);
		return pt;
	}
	
	public void save(PhoneTest pt) {
		dao.save(pt);
	}
	
	
	public String createResMsg(String reqContent,String fromUserName,String toUserName) {
		
		/**
		 * 保存请求内容
		 */
		PhoneTest reqPt = new PhoneTest();
		reqPt.setFromUserName(fromUserName);
		reqPt.setToUserName(toUserName);
		reqPt.setText(reqContent);
		reqPt.setCreate_time(new Date());
		dao.saveReq(reqPt);
		
		
		StringBuffer contentMsg = new StringBuffer();
		/**
		 * 接收内容 长度 小于10执行查询,  
		 *             大于10保存，并返回提交成功
		 */
		if(reqContent!=null&&reqContent.length()<10) {
			
			
			/**
			 * 查询展示表
			 */
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("text","%"+reqContent+"%");
			params.put("today", DateTimeUtil.getCurrentZeroDate());
			params.put("lastDay",DateTimeUtil.getLastDate());
			List<PhoneTest> pt = dao.findListByMap(params);
			System.out.println("pt--service-->"+JSON.toJSONString(pt));
			if(pt!=null&&pt.size()>0) {
				for(int i=0,l=pt.size();i<l;i++) { 
					
					 String lastDay = "";
					 if(pt.get(i).getText().indexOf("明天")>-1&&DateTimeUtil.dateFormat(pt.get(i).getCreate_time()).equals(DateTimeUtil.getLastDate())) {
						 lastDay ="昨天";
					 }
					 contentMsg.append(i+pt.get(i).getText())
					.append("["+lastDay+DateTimeUtil.formatDate(pt.get(i).getCreate_time())+"]")
					.append("\n");
				}
			}else {
				contentMsg.append("“"+reqContent+"”,平台无法查询到匹配信息。");
			}
			
		}else if(reqContent!=null&&reqContent.length()>80) {
			contentMsg.append("发送失败,发送内容不能超出80个字！");
		}else {
			/**
			 * 插入展示表
			 */
			String text = insertDomain(reqContent);
			PhoneTest pt = new PhoneTest();
			pt.setFromUserName(fromUserName);
			pt.setToUserName(toUserName);
			pt.setText(text);
			pt.setCreate_time(new Date());
			save(pt);
			String result = getTextHead(text)+"发送成功，回复目的地可查询该信息！";
			contentMsg.append(result);
			log.info(result);
		}
		return contentMsg.toString();
	} 

	
	public String insertDomain(String text) {
		String result = "";
		String text1 = text.trim();
		List<String> domains = DomainConf.getDomain();
		List<String> dsg = new ArrayList<String>();
		for(String domain:domains){
			if(text1.indexOf(domain)>-1) {
				dsg.add(domain);
			}
		}
		if(dsg.size()==2) {
			if(text1.indexOf(dsg.get(0))<text1.indexOf(dsg.get(1))){
				result = "【"+dsg.get(0)+"→"+dsg.get(1)+"】";
			}else {
				result = "【"+dsg.get(1)+"→"+dsg.get(0)+"】";
			}
		}
		return result+text;
	}
	private String getTextHead(String text) {
		if(text.indexOf("】")>-1) {
			return text.substring(0, text.indexOf("】")+1);
		}
		return "";
	}
}
