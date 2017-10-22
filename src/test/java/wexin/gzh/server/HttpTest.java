package wexin.gzh.server;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;



public class HttpTest {
	String HOST = "127.0.0.1:80";
	@Test
	public void test1() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> res = restTemplate.postForEntity("http://" + HOST + "/testWeixin", null,String.class);
		System.out.println(res.getBody() );
	}
	
	@Test
	public void testDb() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForEntity("http://" + HOST + "/testDB",null);
	}
	
}
