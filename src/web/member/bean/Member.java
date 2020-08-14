package web.member.bean;

import java.sql.Timestamp;
import java.util.Date;

public class Member {
	private String ACCOUNT;
	private String PASSWORD;
	private	String NICKNAME;
	private Boolean PASS;
	private	Timestamp lastUpdateDate;
	public String getACCOUNT() {
		return ACCOUNT;
	}
	public void setACCOUNT(String aCCOUNT) {
		ACCOUNT = aCCOUNT;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getNICKNAME() {
		return NICKNAME;
	}
	public void setNICKNAME(String nICKNAME) {
		NICKNAME = nICKNAME;
	}
	public Boolean getPASS() {
		return PASS;
	}
	public void setPASS(Boolean pASS) {
		PASS = pASS;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Timestamp date) {
		this.lastUpdateDate = date;
	}
	
}
