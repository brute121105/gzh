package weixin.gzh.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import weixin.gzh.server.persistence.pageAble.Dialect;
import weixin.gzh.server.persistence.pageAble.MySQLDialect;
import weixin.gzh.server.persistence.pageAble.MybatisPageableInterceptor;



@SpringBootApplication
public class WeixinGzhServerApplication implements CommandLineRunner{
	final Log logg=LogFactory.getLog(WeixinGzhServerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(WeixinGzhServerApplication.class, args);
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		logg.info("服务器已经启动 success！");	
	}
	
	
	 /**
     * 
    * @methodName:dialect
    * @Description: MySQL分页语法
    * @return
     */
    @Bean
	public Dialect dialect(){
		return new MySQLDialect();
	}
	
    /**
     * 
    * @methodName:mybatisPageableInterceptor
    * @Description: mybatis分页插件
    * @return
     */
	@Bean
	public MybatisPageableInterceptor mybatisPageableInterceptor(){
		MybatisPageableInterceptor mybatisPageableInterceptor = new MybatisPageableInterceptor();
		mybatisPageableInterceptor.setDialect(dialect());
		return mybatisPageableInterceptor;
	}


}
