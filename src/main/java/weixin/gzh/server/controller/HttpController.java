package weixin.gzh.server.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import weixin.gzh.server.conf.ValicodeCache;
import weixin.gzh.server.service.CoreService;
import weixin.gzh.server.util.SignUtil;




@RestController
public class HttpController {
	final Log log=LogFactory.getLog(HttpController.class);
	
	@Autowired
	CoreService coreService;
	
	@RequestMapping(value = "/die", method = RequestMethod.GET)
	public String die() {
		log.info("die--weixin--zc----");
		return "OK";
	}
	
	@RequestMapping(value = "/getValidCode", method = RequestMethod.GET)
	public String getValidCode() {
		String phone = ValicodeCache.phone;
		String code = ValicodeCache.valicode;
		log.info("getValidCodec----"+code);
		return phone+","+code;
	}
	
	@RequestMapping(value = "/sendValidCode", method = RequestMethod.GET)
	public String sendValidCode(String phone,String code) {
		if(!StringUtils.isEmpty(phone)) {
			ValicodeCache.phone = phone;
			log.info("sendValidCode----phone:"+phone);
		}
		if(!StringUtils.isEmpty(code)) {
			ValicodeCache.valicode = code;
			log.info("sendValidCode----code:"+code);
		}
		return "OK";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		       // 微信加密签名
				String signature = request.getParameter("signature");
				// 时间戳
				String timestamp = request.getParameter("timestamp");
				// 随机数
				String nonce = request.getParameter("nonce");
				// 随机字符串
				String echostr = request.getParameter("echostr");

				PrintWriter out = response.getWriter();
				// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
				if (SignUtil.checkSignature(signature, timestamp, nonce)) {
					out.print(echostr);
					System.out.println("微信服务验证成功！");
				}
				out.close();
				out = null;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");

				// 调用核心业务类接收消息、处理消息
				String respMessage = coreService.processRequest(request);
				
				// 响应消息
				PrintWriter out = response.getWriter();
				out.print(respMessage);
				
				out.close();
	}

}
