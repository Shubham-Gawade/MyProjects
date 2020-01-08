package com.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DatabaseDao.DatabaseHelper;
import com.Model.LoginAccount;

/**
 * Servlet implementation class LoginAccountController
 */
@WebServlet("/LoginAccountController")
public class LoginAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAccountController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		
		LoginAccount obj=new LoginAccount();
		obj.setUname(uname);
		obj.setPass(pass);
		
		List<LoginAccount> list=new ArrayList<LoginAccount>();
		list.add(obj);
		
		DatabaseHelper rd= new DatabaseHelper();
		int i=rd.validateAccount(list);
		
		if(i>0)
		{
			HttpSession session=request.getSession();
			session.setAttribute("username", uname);
			response.sendRedirect("Welcome.jsp");
		}	
		else
		{
			HttpSession session=request.getSession();
			String uname1="Invalid";
			session.setAttribute("username", uname1);
			response.sendRedirect("Login.jsp");
		}
	}

}
