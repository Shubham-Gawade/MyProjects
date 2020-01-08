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
 * Servlet implementation class ChangePinController
 */
@WebServlet("/ChangePinController")
public class ChangePinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePinController() {
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
		String epin=request.getParameter("epin");
		String cpin=request.getParameter("cpin");
		if(!(epin.equals(cpin)))
		{
			response.sendRedirect("ChangePin.jsp");
		}
		else
		{
			HttpSession session=request.getSession();
			String username=(String)session.getAttribute("username");
			System.out.println(username);
			DatabaseHelper dbobj=new DatabaseHelper();
			int cnt=dbobj.changePin(username,epin);
			if(cnt>0)
			{
				response.sendRedirect("PinGenerated.jsp");
			}
			else
			{
				response.sendRedirect("ChangePin.jsp");
			}
		}
	}

}
