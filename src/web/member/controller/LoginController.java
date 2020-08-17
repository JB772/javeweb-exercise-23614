package web.member.controller;

//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//@WebServlet("/LoginController")
//public class LoginController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//	}
//
//}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import web.member.bean.Member;
import web.member.service.MemberService;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Gson GSON = new GsonBuilder().create();
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			
			Member member = json2Member(req);
			String htmlAccount = member.getAccount();
			String htmlPassword = member.getPassword();
//			member.setPass(true);
//			member.setLast_update_date(new Timestamp(System.currentTimeMillis()));
			
			System.out.println(htmlAccount);
			System.out.println(htmlPassword);
			MemberService mService = new MemberService();
			if(mService.Login(htmlAccount, htmlPassword) == 1) {
				WriteJson(resp, member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}


	private Member json2Member(HttpServletRequest req) {
		StringBuilder json = new StringBuilder();
		try (BufferedReader br = req.getReader()){
			String line;
			while ((line = br.readLine()) != null) {
				json.append(line);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return GSON.fromJson(json.toString(), Member.class);
	}
	
	private void WriteJson(HttpServletResponse resp, Member member) {
		try(PrintWriter pw = resp.getWriter()) {
			pw.print(GSON.toJson(member));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

