package web.member.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.member.bean.Member;
@WebServlet("/LoginController")
public class LoginController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		Member member = jason2Member(req);
		WriteJson(resp, member);
	}
	

	private Member jason2Member(HttpServletRequest req) {
		StringBuilder jsonMemer = new StringBuilder();
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	private void WriteJson(HttpServletResponse resp, Member member) {
		// TODO Auto-generated method stub
		
	}
}
