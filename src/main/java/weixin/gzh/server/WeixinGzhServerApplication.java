package weixin.gzh.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeixinGzhServerApplication {
	final Log logg=LogFactory.getLog(WeixinGzhServerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(WeixinGzhServerApplication.class, args);
	}

}
