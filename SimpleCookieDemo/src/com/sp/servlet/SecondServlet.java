package com.sp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SecondServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
		//genarl settings
		PrintWriter pw = null;
		pw = res.getWriter();
		res.setContentType("text/html");
		String age = null;
		String a_name  = null;
		//get the data from form2/req	
		age = req.getParameter("age");
		
		int a = Integer.parseInt(age);
		
		//get the cookie
		Cookie[] ck = req.getCookies();
		String name = ck[0].getValue();
		//service logic
		if(a <= 18)
		{
			a_name = "Young";
		}
		else 
		{
			a_name = "Adult";
		}
		
		pw.println("Hello .."+name+"..According to your age :"+age+" you are "+a_name);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
