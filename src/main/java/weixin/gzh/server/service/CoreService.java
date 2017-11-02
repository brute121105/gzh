package weixin.gzh.server.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weixin.gzh.server.dao.PhoneMapper;
import weixin.gzh.server.model.PhoneTest;
import weixin.gzh.server.model.res.Article;
import weixin.gzh.server.model.res.NewsMessage;
import weixin.gzh.server.model.res.TextMessage;
import weixin.gzh.server.util.MessageUtil;

/**
 * 核心服务类
 * 
 * @author liufeng
 * @date 2013-07-25
 */
@Service
public class CoreService {
	
	private static Logger log = LoggerFactory.getLogger(CoreService.class);
	@Autowired
	DaoService daoService;
	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */
	public  String processRequest(HttpServletRequest request) {
		String respMessage = null;
		try {
			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");
			log.info("msgType:"+msgType);
			log.info("fromUserName:"+fromUserName);
			log.info("toUserName:"+toUserName);
			
			String content1 = requestMap.get("Content");
			log.info("content1:"+content1);

			// 默认回复此文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);
			textMessage.setContent(daoService.createResMsg(content1,fromUserName,toUserName));
			
			// 将文本消息对象转换成xml字符串
			respMessage = MessageUtil.textMessageToXml(textMessage);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respMessage;
	}
	

	/**
	 * emoji表情转换(hex -> utf-16)
	 * 
	 * @param hexEmoji
	 * @return
	 */
	public static String emoji(int hexEmoji) {
		return String.valueOf(Character.toChars(hexEmoji));
	}
}