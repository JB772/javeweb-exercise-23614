package web.member.service;


import java.util.List;

import web.member.bean.Member;
import web.member.dao.MemberDao;
import web.member.dao.impl.MemberDaoimpl;


public class MemberService {
	private MemberDao<Member, String> dao ;

	public MemberService() {
		dao = new MemberDaoimpl();
	}
	
	//註冊，拿到Member物件，檢查account是否存在，存在return，不存在就insert
	public int register(Member member) {
		int acoountExist = 2;
		//int registerSuccess = 1;
		String registrAccount = member.getAccount();
		if (dao.selectByKey(registrAccount) == null) {
			return dao.insert(member);
		}else {
			return acoountExist;
		}
	}
	//登入
	//拿到acconut及password，用account去selecByKey，若回傳的Member物件==null，return ；
	//若回傳的Member物件!=null，再檢查password是否 ==。
	public int login(String account, String password) {
		int LoginSuccess = 1;
		int LoginNoAccount = 2;
		int LoginErrorPassword = 3;
		System.out.println("account:"+account);
		System.out.println("password:"+password);
		
		if (dao.selectByKey(account) == null) {
			System.out.println(LoginNoAccount);
			return LoginNoAccount;
		}else {
			Member memberByKey = dao.selectByKey(account);
			if(!memberByKey.getPassword().equals(password)) {
				System.out.println(LoginErrorPassword);
				return LoginErrorPassword;
			}else {
				System.out.println(LoginSuccess);
				return LoginSuccess;
			}
		}
	}
	//修改會員資料
	public int updateMember(Member member) {
		int updateFalse = -1;
		if (dao.selectByKey(member.getAccount()) == null) {
			return updateFalse;
		}else {
			return dao.update(member);
		}
	}
	//刪除會員資料
	public int deletaMember(Member member) {
		return dao.deletaByKey(member.getAccount());
	}
	//查詢MEMBER資料表
	public List<Member> selectMemberTable() {
		return dao.selectAll();
	}
}
