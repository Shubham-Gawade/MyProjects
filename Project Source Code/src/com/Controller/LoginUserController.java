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
 * Servlet implementation class LoginUserController
 */
@WebServlet("/LoginUserController")
public class LoginUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String password=request.getParameter("pass");
		DatabaseHelper dbobj=new DatabaseHelper();
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		List<LoginAccount> lst=new ArrayList<LoginAccount>();
		LoginAccount obj=new LoginAccount();
		obj.setUname(username);
		obj.setPass(password);
		lst.add(obj);
		int cnt=dbobj.validateAccount(lst);
		if(cnt>0)
		{
			response.sendRedirect("ChangeUserId.jsp");
		}
		else
		{
			response.sendRedirect("EnterLogin1.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
