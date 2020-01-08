package com.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DatabaseDao.DatabaseHelper;
import com.Model.DisplayAllData;
import com.Model.DisplayProfile;

/**
 * Servlet implementation class MyProfileController
 */
@WebServlet("/MyProfileController")
public class MyProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyProfileController() {
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
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		DatabaseHelper db = new DatabaseHelper();
		List<DisplayProfile> lst=db.getMyProfileAcc(username);
		HttpSession session1=request.getSession(true);
		session1.setAttribute("AllvalidAcc",lst);
		response.sendRedirect("MyProfile.jsp");
	}

}
