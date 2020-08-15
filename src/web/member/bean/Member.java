package web.member.bean;

import java.sql.Timestamp;

public class Member {
	private String account;
	private String password;
	private	String nickname;
	private Boolean pass;
	private	Timestamp lastUpdateDate;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Boolean getPass() {
		return pass;
	}

	public void setPass(Boolean pass) {
		this.pass = pass;
	}

	public Timestamp getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Integer getRole_ID() {
		return role_ID;
	}

	public void setRole_ID(Integer role_ID) {
		this.role_ID = role_ID;
	}
	
	
}
