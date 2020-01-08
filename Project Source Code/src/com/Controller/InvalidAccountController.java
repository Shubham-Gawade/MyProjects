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

import com.DatabaseDao.DatabaseHelper;
import com.Model.CreateAccount;


/**
 * Servlet implementation class InvalidAccountController
 */
@WebServlet("/InvalidAccountController")
public class InvalidAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InvalidAccountController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseHelper Dbobj=new DatabaseHelper();
		List<CreateAccount> lst=Dbobj.getAllData();
		
		CreateAccount obj=lst.get(0);
		String ReceiverAddress=obj.getEmailId();
		String User_id=obj.getUserId();
		
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
             message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(ReceiverAddress));
             message.setSubject("Mail By SMP Bank");
             message.setText("Mail By SMP Bank ...Your Information is invalid to create account in our Bank. Please register again with valid information");

             Transport.send(message);

             System.out.println("Mail send..!!");

         } 
         catch (MessagingException e) 
         {
             e.printStackTrace();
         }
         int cnt=Dbobj.deleteAccountFromTemp(User_id);
         if(cnt>0)
         {
        	 response.sendRedirect("AdminDatabaseDisplay.jsp");
        	 System.out.println("Data Deleted from user Temprory table");
         }
         else
         {
        	 System.out.println("Data Not Deleted from user Temprory table");
         }
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
