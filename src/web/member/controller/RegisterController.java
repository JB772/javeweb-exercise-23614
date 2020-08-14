package web.member.controller;

<<<<<<< HEAD
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/RegisterController")
//public class RegisterController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//    
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	
//	}
//
//}
import java.io.BufferedReader;
import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
=======
import java.io.IOException;

>>>>>>> b00f576501caa4a9a230cd180fff9b9918f5ad70
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import web.member.bean.Member;


@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Gson GSON = new GsonBuilder().create();
       
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			Member member = json2Member(req);
			
			member.setAccount(member.getAccount());
			member.setPassword(member.getPassword());
			member.setNickname(member.getNickname());
			member.setLastUpdateDate(member.getLastUpdateDate());
			member.setId(member.getId());
			member.setPath(false);
			
			
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

=======
@WebServlet
public class RegisterController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
>>>>>>> b00f576501caa4a9a230cd180fff9b9918f5ad70
}
