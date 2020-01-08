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
 * Servlet implementation class SetPinController
 */
@WebServlet("/SetPinController")
public class SetPinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetPinController() {
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
		String pin=request.getParameter("pin");
		String confirmpin=request.getParameter("confpin");
		if(!(pin.equals(confirmpin)))
		{
			response.sendRedirect("SetpinPermanant.jsp");
		}
		else
		{
			HttpSession session=request.getSession();
			String username=(String)session.getAttribute("username");
			DatabaseHelper dbobj=new DatabaseHelper();
			int cnt=dbobj.insertTrasactionPin(username,pin);
			if(cnt>0)
			{
				response.sendRedirect("Welcome.jsp");
			}
			else
			{
				response.sendRedirect("SetpinPermanant.jsp");
			}
		}
	}

}
