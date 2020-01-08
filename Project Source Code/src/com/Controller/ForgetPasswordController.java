package com.Controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DatabaseDao.DatabaseHelper;

/**
 * Servlet implementation class ForgetPasswordController
 */
@WebServlet("/ForgetPasswordController")
public class ForgetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPasswordController() {
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
		String username=request.getParameter("uname");
		String emailId=request.getParameter("email");
		
		DatabaseHelper dbobj=new DatabaseHelper();
		int email=dbobj.checkEmail(username,emailId);
		if(email>0)
		{
			int pass=dbobj.generatePassword();
			String newpass=String.valueOf(pass);
			final String senderUsername = "shubhamiit91@gmail.com";
	        final String password = "ksfalgrggojuxkuh";  

	        Properties prop = new Properties();
	 		prop.put("mail.smtp.host", "smtp.gmail.com");
	        prop.put("mail.smtp.port", "587");
	        prop.put("mail.smtp.auth", "true");
	        prop.put("mail.smtp.starttls.enable", "true"); //TLS
	         
	        Session session = Session.getInstance(prop,new javax.mail.Authenticator()
	        {
	             protected PasswordAuthentication getPasswordAuthentication()
	             {
	                 return new PasswordAuthentication(senderUsername, password);
	             }
	        });

	         try 
	         {
	             Message message = new MimeMessage(session);
	             message.setFrom(new InternetAddress(senderUsername));
	             message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(emailId));
	             message.setSubject("Mail By Bank");
	             message.setText("Your Password is changed...");
	             message.setText("Username:  "+username+"     Password : "+pass);

	             Transport.send(message);

	             System.out.println("Mail send..!");
	             
	             int cnt=dbobj.changePass(username, newpass);
	             if(cnt>0)
	             {
	            	 response.sendRedirect("Login.jsp");
	            	 System.out.println("Password Changed");
	             }
	             else
	             {
	            	 System.out.println("Password not changed");
	             }

	         } 
	         catch (MessagingException e) 
	         {
	             e.printStackTrace();
	         }
		}
		else
		{
			response.sendRedirect("FogetPassword.jsp");
		}
	}

}
