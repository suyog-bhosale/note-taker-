package com.servlate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.factoryprovider;

/**
 * Servlet implementation class SaveNote
 */
public class SaveNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
  		try {
  			
  			String title=request.getParameter("title");
  			String content=request.getParameter("content");
  			
  			Note note=new Note(title,content,new Date());
  			
  		//	System.out.println(note.getId()+" :"+note.getTitle());
  		// hibernate.save()
  			
  		Session s=	factoryprovider.getFacory().openSession();
  		Transaction tx=s.beginTransaction();
  			
  			s.save(note);
  			response.setContentType("text/html");
  			PrintWriter out=response.getWriter();
  			out.println("<h1> code run succfully</h1>");
  			System.out.println("<a href='All_Note.jsp'>View_All<>");
  			
  			
  			tx.commit();
  		s.close();
  		
		} catch (Exception e) {
			// TODO: handle exception
		}
  		
	}

}
