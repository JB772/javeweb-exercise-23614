package web.member.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
			pstmt.setObject(3, bean.getNickName());
			pstmt.setObject(3, bean.getPass());
			pstmt.setObject(4, bean.getLast_update_date());
			pstmt.setObject(5, bean.getRole_ID());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public Member selectByKey(String account) {
		String sql = "select * from MEMBER where ACCOUNT = ?";
		try(Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, account);
			Member memberByKey = new Member();
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				memberByKey.setPassword(rs.getString("password"));
				memberByKey.setNickName(rs.getString("nickName"));
				memberByKey.setPass(rs.getBoolean("pass"));
				memberByKey.setLast_update_date(rs.getTimestamp("last_update_date"));
				return memberByKey;
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Member> selectAll() {
		String sql = "select * from MEMBER";
		try(Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();) {
			List<Member> list= new ArrayList<Member>();
			while(rs.next()) {
				Member member = new Member();
				member.setAccount(rs.getString("ACCOUNT"));
				member.setPassword(rs.getString("PASSWORD"));
				member.setNickName(rs.getString("NICKNAME"));
				member.setPass(rs.getBoolean("PASS"));
				member.setLast_update_date(rs.getTimestamp("LAST_UPDATE_DATE"));
				member.setRole_ID(rs.getInt("ROLE_ID"));
				list.add(member);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
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
			pstmt.setString(2, bean.getNickName());
			pstmt.setBoolean(3, bean.getPass());
			pstmt.setTimestamp(4, bean.getLast_update_date());
			pstmt.setInt(5, bean.getRole_ID());
			pstmt.setString(6, bean.getAccount());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int deletaByKey(String account) {
		String sql = "delete MEMBER where ACCOUNT = ?";
		try (Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, "account");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
