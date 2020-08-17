package web.member.service;


import web.member.bean.Member;
import web.member.dao.MemberDao;
import web.member.dao.impl.MemberDaoimpl;


public class MemberService {
	private MemberDao<Member, String> dao ;

	public MemberService() {
		dao = new MemberDaoimpl();
	}
	
	//拿到Member物件，檢查account是否存在，存在return，不存在就insert
	public int Register(Member member) {
		String registrAccount = member.getAccount();
		if (registrAccount == dao.selectByKey(registrAccount).getAccount()) {
			return -1;
		}
		dao.insert(member);
		if(dao.insert(member)==1) {
			return 1;
		}
		return 0;
	}
	
	//拿到acconut及password，用account去selecByKey，若回傳的Member物件==null，return ；
	//若回傳的Member物件!=null，再檢查password是否 ==。
	public int Login(String account, String password) {
		int LoginSuccess = 1;
		int LoginNoAccount = 0;
		int LoginErrorPassword = -1;
		
		Member memberL = dao.selectByKey(account);
		if (memberL == null) {
			return LoginNoAccount;
		}else {
			if (memberL.getPassword() != password) {
				return LoginErrorPassword;
			}
		}
		return LoginSuccess;
	}
	
}
