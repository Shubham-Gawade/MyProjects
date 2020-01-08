package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.codec.binary.Base64;

import com.DatabaseDao.DatabaseHelper;

/**
 * Servlet implementation class IntraBankingController
 */
@WebServlet("/IntraBankingController")
public class IntraBankingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IntraBankingController() {
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
		
		long accountNo=Long.parseLong(request.getParameter("Accno"));  //receiver
		long amount=Long.parseLong(request.getParameter("Amount"));   //sending amount
		String pin=request.getParameter("pin");
		
		DatabaseHelper dbobj=new DatabaseHelper();
		long customer_id=dbobj.findCustomerId(username);  //sender
		System.out.println(customer_id);
		
		String pin1=dbobj.searchPin(username);
		byte[] decode=Base64.decodeBase64(pin1.getBytes());
		String pass1=new String(decode);
		System.out.println(pass1);
		int i=dbobj.findAccountno(accountNo);
		
		if(pin.equals(pass1) && i==1)
		{
			long transactionid=dbobj.generateTransactionId();
			int cnt=dbobj.debitAmount(transactionid,accountNo,amount,username);
			if(cnt>0)
			{
				
				System.out.println("Amount Debited");
			}
			else
			{
				
				System.out.println("Amount Not Debited");
			}
			
			long transactionid2=dbobj.generateTransactionId();
			int cnt2=dbobj.creditAmount(transactionid2,accountNo,amount,username);
			System.out.println("credit");
			if(cnt2>0)
			{
				System.out.println("Amount Credited");
				response.sendRedirect("TransactionSucessful.jsp");
			}
			else
			{
				System.out.println("Amount Not Credited");
				
			}
		}
		else
		{
			HttpSession session1=request.getSession();
			String pin3;
			pin3="Invalid";
			session1.setAttribute("pin", pin3);
			response.sendRedirect("IntraBankingTransfer.jsp");
		}
	}

}
