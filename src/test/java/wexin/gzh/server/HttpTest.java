package wexin.gzh.server;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;

import weixin.gzh.server.conf.DomainConf;
import weixin.gzh.server.service.DataService;



public class HttpTest {
	//String HOST = "127.0.0.1:80";
	String HOST = "120.78.134.230:80";
	@Test
	public void test1() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> res = restTemplate.postForEntity("http://" + HOST + "/testWeixin", null,String.class);
		System.out.println(res.getBody() );
	}
	
	@Test
	public void testDb() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> resp = restTemplate.getForEntity("http://" + HOST + "/testDB",Object.class);
		System.out.println("-->"+JSON.toJSONString(resp.getBody()));
	}
	
	@Test
	public void testDBLike() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForEntity("http://" + HOST + "/testDBQC",null);
	}
	@Test
	public void testUtil() {
		System.out.println(JSON.toJSONString(DomainConf.getDomain()));
		DataService service = new DataService();
	}
	
	@Test
	public void getValidCode(){
		   RestTemplate restTemplate = new RestTemplate();
		   String url = "http://"+HOST+"/getValidCode";
		   Object res = restTemplate.getForObject(url,String.class);
		   System.out.println("res-->"+JSON.toJSONString(res));
		}
	
	@Test
	public void sendValidCode(){
		   RestTemplate restTemplate = new RestTemplate();
		   String url = "http://"+HOST+"/sendValidCode?phone=13651589844&code=111";
		   Object res = restTemplate.getForObject(url,String.class);
		   System.out.println("res-->"+JSON.toJSONString(res));
		}
	
}
