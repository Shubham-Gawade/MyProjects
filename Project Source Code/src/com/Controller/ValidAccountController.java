package com.Controller;

import java.io.IOException;
import java.util.List;
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

import org.apache.tomcat.util.codec.binary.Base64;

import com.DatabaseDao.DatabaseHelper;
import com.Model.CreateAccount;
import com.Model.LoginInfo;

/**
 * Servlet implementation class ValidAccountController
 */
@WebServlet("/ValidAccountController")
public class ValidAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidAccountController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseHelper dbobj=new DatabaseHelper();
		List<CreateAccount> lst=dbobj.getAllData();
		
		dbobj.splitAndCopyAccount(lst);
		
		CreateAccount obj=lst.get(0);
		String User_id=obj.getUserId();
		
		long Customer_id=dbobj.findCustomerId(User_id);
		
		List<LoginInfo> lst1=dbobj.findPassAccNo(Customer_id);
		LoginInfo obj1=lst1.get(0);
		
		String pass=obj1.getPassword();
		byte[] bytes=pass.getBytes();
		byte[] decode=Base64.decodeBase64(bytes);
		String pass1=new String(decode);
		long Accno=obj1.getAccountNo();
		String email=obj1.getEmailId();
		
		final String username = "shubhamiit91@gmail.com";
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
                 return new PasswordAuthentication(username, password);
             }
        });

         try 
         {
             Message message = new MimeMessage(session);
             message.setFrom(new InternetAddress(username));
             message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email));
             message.setSubject("Mail By SMP Bank");
             message.setText("Hello, dear customer...Your account is created in our Bank. Please checkout the following details");
             message.setText("Mail By SMP Bank...Hello, dear customer...Your account is created in our Bank. Please checkout the following details .Account No.:  "+Accno+"     Password : "+pass1+"     User_id : "+User_id);

             Transport.send(message);

             System.out.println("Mail send..!");

         } 
         catch (MessagingException e) 
         {
             e.printStackTrace();
         }
         
         int cnt=dbobj.deleteAccountFromTemp(User_id);
         if(cnt>0)
         {
        	 response.sendRedirect("AdminDatabaseDisplay.jsp");
        	 System.out.println("Account data Deleted From UserTempdata");
         }
         else
         {
        	 System.out.println("Account data not Deleted From UserTempdata");
         }
	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

	}
}
