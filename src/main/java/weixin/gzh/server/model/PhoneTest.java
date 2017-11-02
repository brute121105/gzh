/**
 * 
 */
package weixin.gzh.server.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: PhoneTest
 * @Description: TODO()
 * @author yejie.huang
 * @date 2017年7月3日 下午4:17:47
 *
 */

public class PhoneTest implements Serializable{
	
	private static final long serialVersionUID = -7035664936951765760L;
	private Integer id;
	private String userId;
	private String phone;
	private String text;
	
	private String fromUserName;
	private String toUserName;
	private Date create_time;
	
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	
	

}
