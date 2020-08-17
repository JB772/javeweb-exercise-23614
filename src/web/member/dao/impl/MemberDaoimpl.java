package web.member.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

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
		String sql = "insert into MEMBER(ACCOUNT, PASSWORD, NICKNAME, PASS, LASTUPDATEDATE, ROLE_ID) "
				+ "values	(?,?,?,?,?)";
		try(Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setObject(1, bean.getAccount());
			pstmt.setObject(2, bean.getPassword());
			pstmt.setObject(3, bean.getNickname());
			pstmt.setObject(3, bean.getPass());
			pstmt.setObject(4, bean.getLastUpdateDate());
			pstmt.setObject(5, bean.getRole_ID());
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
				memberByKey.setAccount(rs.getNString("account"));
				memberByKey.setPassword(rs.getNString("password"));
				memberByKey.setLastUpdateDate(rs.getTimestamp("lastUpdateDate"));
				memberByKey.setPass(rs.getBoolean("pass"));
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

	@Override
	public int update(Member bean) {
		String sql = "update Member set"
				+ "PASSWORD =?,"
				+ "NICKNAME =?,"
				+ "PASS =?,"
				+ "LASTUPDATEDATE =?,"
				+ "ROLE_ID =? "
			+"where ACCOUNT = ? ";

		try(Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setString(1, bean.getPassword());
			pstmt.setString(2, bean.getNickname());
			pstmt.setBoolean(3, bean.getPass());
			pstmt.setTimestamp(4, bean.getLastUpdateDate());
			pstmt.setInt(5, bean.getRole_ID());
			pstmt.setString(6, bean.getAccount());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int deletaByKey(String key) {
		String sql = "";
		try (Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
