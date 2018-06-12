package com.sp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class FirstServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = null;
		//genral settings
		PrintWriter pw =null;
		pw = res.getWriter();
		res.setContentType("text/html");
		
		//get the form data 
		name = req.getParameter("name");
		
		//create cookie object and save the form1/req1 data into cookie
		Cookie ck = new Cookie ("name", name);
		
		res.addCookie(ck);
		
		//create the new form2 
		pw.println("<form action='./secondurl' method = 'post'>");
		pw.println("<body bgcolor = 'pink'>");
		pw.println("<div align = 'center'> <h1 style='color:red;'>Second form Created by FirstServlet</h1>");
		pw.println("<br>Age  :: <input type='text' name ='age'> ");
		pw.println("<br><br><br><input type='submit' value='Submit'>");
		pw.println("</div>");
		
		pw.println("</body></form>");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
