package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DatabaseDao.DatabaseHelper;

/**
 * Servlet implementation class ChangeUserIdController
 */
@WebServlet("/ChangeUserIdController")
public class ChangeUserIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeUserIdController() {
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
		String cname=request.getParameter("cname");
		if(!(uname.equals(cname)))
		{
			response.sendRedirect("ChangeUserId.jsp");
		}
		else
		{
			HttpSession session=request.getSession();
			String username=(String)session.getAttribute("username");
			System.out.println(username);
			DatabaseHelper dbobj=new DatabaseHelper();
			int cnt=dbobj.changeUserId(username,uname);
			if(cnt>0)
			{
				
				response.sendRedirect("UseridChanged.jsp");
			}
			else
			{
				response.sendRedirect("ChangeUserId.jsp");
			}
		}
	}

}
