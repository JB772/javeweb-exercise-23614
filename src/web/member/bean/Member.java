package web.member.bean;

import java.sql.Timestamp;

public class Member {
	private String account;
	private String password;
	private	String nickName;
	private Boolean pass;
	private	Timestamp last_update_date;
	private Integer role_ID;
	
	public Member() {
		super();
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Boolean getPass() {
		return pass;
	}

	public void setPass(Boolean pass) {
		this.pass = pass;
	}

	public Timestamp getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Timestamp lastUpdateDate) {
		this.last_update_date = lastUpdateDate;
	}

	public Integer getRole_ID() {
		return role_ID;
	}

	public void setRole_ID(Integer role_ID) {
		this.role_ID = role_ID;
	}
	
	
}
