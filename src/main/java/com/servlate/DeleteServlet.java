package com.servlate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.factoryprovider;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try { 
			int noteId=Integer.parseInt(request.getParameter("note_id").trim());
			Session s=factoryprovider.getFacory().openSession();
			Transaction Tx=s.beginTransaction();
			 	Note note=(Note)s.get(Note.class, noteId);
			 	s.delete(note);
			 	Tx.commit();
			 	s.close();
			 	response.sendRedirect("All_Notes.jsp");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	

	
	}

}
