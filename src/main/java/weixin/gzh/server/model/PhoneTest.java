/**
 * 
 */
package weixin.gzh.server.model;

import java.io.Serializable;

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
	private String phone;
	private String text;
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

}
