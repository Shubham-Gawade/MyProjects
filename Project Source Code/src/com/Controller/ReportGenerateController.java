package com.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DatabaseDao.DatabaseHelper;
import com.Model.Transaction;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class ReportGenerateController
 */
@WebServlet("/ReportGenerateController")
public class ReportGenerateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportGenerateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		String fromdate=request.getParameter("fromdate");
		String todate=request.getParameter("todate");
		
		DatabaseHelper dbobj=new DatabaseHelper();
		long customerId=dbobj.findCustomerId(username);
		System.out.println(customerId);
		
		List<Transaction> lst=new ArrayList<Transaction>();
		lst=dbobj.getTransactionHistory(customerId,fromdate,todate);
		Iterator<Transaction> itr=lst.iterator();
		while(itr.hasNext())
		{
			Transaction obj=new Transaction();
			obj=itr.next();
			System.out.println(obj.getTransactionId()+" "+obj.getAmount()+" "+obj.getDateOftransaction()
			+" "+obj.getStatus()+" "+obj.getDiscription());
		}
		try 
		{
			String home= System.getProperty("user.home");
			File file=new File(home+"/Downloads/"+"report.pdf");
			Document document=new Document();
			PdfWriter.getInstance(document, new  FileOutputStream(file));
			document.open();
			try 
			{
				Iterator<Transaction> itr1=lst.iterator();
				while(itr1.hasNext())
				{
					Transaction obj1=new Transaction();
					obj1=itr1.next();
					Paragraph para=new Paragraph(obj1.getTransactionId()+" "+obj1.getAmount()+" "+obj1.getDateOftransaction()
					+" "+obj1.getStatus()+" "+obj1.getDiscription());
					document.add(para);
					document.add(new Paragraph(" "));
				}
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
	
			document.close();
			System.out.println("Finished....");
			
			response.sendRedirect("Welcome.jsp");
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (DocumentException e) 
		{	
			e.printStackTrace();
		}
	}

}
