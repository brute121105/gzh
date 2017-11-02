package weixin.gzh.server.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.assertj.core.util.DateUtil;
import org.springframework.util.StringUtils;

import weixin.gzh.server.controller.HttpController;

public class DateTimeUtil {
	final Log log=LogFactory.getLog(DateTimeUtil.class);
	public static String formatDate(Date date) {
		if(StringUtils.isEmpty(date)) return "";
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		return sdf.format(date);
	}
	
	public static Date getCurrentZeroDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String ymd = sdf.format(new Date());
		try {
			return sdf.parse(ymd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//获取上一天
	public static String getLastDate(){
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 Calendar cal = Calendar.getInstance();
		 cal.add(Calendar.DATE, -1);
		return sdf.format(cal.getTime());
	}
	
	public static String dateFormat(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("--->"+getLastDate());
		System.out.println("--->"+sdf.format(getCurrentZeroDate()));
	}

}
