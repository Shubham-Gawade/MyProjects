package com.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DatabaseDao.DatabaseHelper;
import com.Model.CreateAccount;

/**
 * Servlet implementation class CreateAccountController
 */
@WebServlet("/CreateAccountController")
public class CreateAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccountController() {
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
		String Firstname=request.getParameter("fname");
		String Lastname=request.getParameter("lname");
		String Gender=request.getParameter("gender");
		String DateOfBirth=request.getParameter("dob");
		String Area=request.getParameter("area");
		String City=request.getParameter("city");
		String State=request.getParameter("state");
		long Pincode=Long.parseLong(request.getParameter("pincode"));
		String Nationality=request.getParameter("nationality");
		long Adharno=Long.parseLong(request.getParameter("adharno"));
		long Mobileno=Long.parseLong(request.getParameter("mono"));
		String EmailId=request.getParameter("email");
		String Username=request.getParameter("username");
		String AccType=request.getParameter("accounttype");
		String BranchName=request.getParameter("branchname");
		
		
		DatabaseHelper DbObj=new DatabaseHelper();

		CreateAccount createAccountObj=new CreateAccount();
		createAccountObj.setFirstName(Firstname);
		createAccountObj.setLastName(Lastname);
		createAccountObj.setGender(Gender);
		createAccountObj.setDateOfBirth(DateOfBirth);
		createAccountObj.setArea(Area);
		createAccountObj.setState(State);
		createAccountObj.setCity(City);
		createAccountObj.setPinCode(Pincode);
		createAccountObj.setNationality(Nationality);
		createAccountObj.setAdharNo(Adharno);
		createAccountObj.setMobileNo(Mobileno);
		createAccountObj.setEmailId(EmailId);
		createAccountObj.setUserId(Username);
		createAccountObj.setAccType(AccType);
		createAccountObj.setBranchName(BranchName);
		
		List<CreateAccount> Accountlist=new ArrayList<CreateAccount>();
		Accountlist.add(createAccountObj);
		
		int count=DbObj.createAccount(Accountlist);
		if(count>0)
		{
			response.sendRedirect("registermsg.jsp");
		}
		else
		{
			response.sendRedirect("CreateAccount.jsp");
		}
	}

}
