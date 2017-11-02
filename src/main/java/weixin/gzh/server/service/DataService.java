package weixin.gzh.server.service;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import weixin.gzh.server.conf.DomainConf;


@Service
public class DataService {
	private static Logger log = LoggerFactory.getLogger(DataService.class);
	
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
				result = "["+dsg.get(0)+"→"+dsg.get(1)+"] ";
			}else {
				result = "["+dsg.get(1)+"→"+dsg.get(0)+"] ";
			}
		}
		return result+text;
	}
}
