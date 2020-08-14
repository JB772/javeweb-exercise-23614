package web.member.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.cj.protocol.Resultset;
import com.zaxxer.hikari.HikariDataSource;

import web.member.bean.Member;
import web.member.dao.MemberDao;

public class MemberDaoimpl implements MemberDao<Member, String>{
	private DataSource ds;
	
	public MemberDaoimpl() {
		try {
			ds = (DataSource)new InitialContext().lookup("java:/comp/env/jdbc/example");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(Member bean) {
		String sql = "insert into Member(account, password, pass, lastUpdateDate) "
				+ "values	(?,?,?,?)";
		try(Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setObject(1, bean.getACCOUNT());
			pstmt.setObject(2, bean.getPASSWORD());
			pstmt.setObject(3, bean.getPASS());
			pstmt.setObject(4, bean.getLastUpdateDate());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public Member selectByKey(String key) {
		String sql = "select * from MEMBER where ACCOUNT = ?";
		try(Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			Member memberByKey = new Member();
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				memberByKey.setACCOUNT(rs.getNString("ACCOUNT"));
				memberByKey.setPASSWORD(rs.getNString("ACCOUNT"));
				memberByKey.setPASS(rs.getBoolean("PASS"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Member> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
