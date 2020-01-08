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
 * Servlet implementation class ChangeMobNoController
 */
@WebServlet("/ChangeMobNoController")
public class ChangeMobNoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeMobNoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String emob=request.getParameter("emob");
		String cmob=request.getParameter("cmob");
		if(!(emob.equals(cmob)))
		{
			response.sendRedirect("ChangeMobNo.jsp");
		}
		else
		{
			HttpSession session=request.getSession();
			String username=(String)session.getAttribute("username");
			System.out.println(username);
			DatabaseHelper dbobj=new DatabaseHelper();
			int cnt=dbobj.changeMobNo(username,emob);
			if(cnt>0)
			{
				response.sendRedirect("Mobilechanged.jsp");
			}
			else
			{
				response.sendRedirect("ChangeMobNo.jsp");
			}
		}
	}
}

