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
 * Servlet implementation class ChangeMailController
 */
@WebServlet("/ChangeMailController")
public class ChangeMailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeMailController() {
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
		String email=request.getParameter("email");
		String cmail=request.getParameter("cmail");
		if(!(email.equals(cmail)))
		{
			response.sendRedirect("ChangeMail.jsp");
		}
		else
		{
			HttpSession session=request.getSession();
			String username=(String)session.getAttribute("username");
			System.out.println(username);
			DatabaseHelper dbobj=new DatabaseHelper();
			int cnt=dbobj.changeMail(username,email);
			int cnt1=dbobj.changeMail1(username,email);
			if(cnt>0 && cnt1>0)
			{
				response.sendRedirect("MailChanged.jsp");
			}
			else
			{
				response.sendRedirect("ChangeMail.jsp");
			}
		}
	}

}
