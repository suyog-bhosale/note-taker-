<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="com.helper.factoryprovider"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.entities.*"%>
<%@page import="org.hibernate.Query"
 %>
 <%@page import="java.util.List " %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All note:taker</title>
<%@include file=All_Note.jsp %>
</head>
<body>

<div class="container-fluid">
<%@include file="NavBar.jsp"%>
		
		
	<div class="row">
		
		<div class="col-12">
		
		<h1> All Notes</h1>
		
		<%
			Session s=factoryprovider.getFacory().openSession();
			Query q=s.createQuery(" form Note");
			List<Note> list=q.list();
			
			for(Note n:list){
				%>
		<div class="card" style="width: 18rem;">
			
			<div class="card-body">
				<h5 class="card-title"><%= n.getTitle() %></h5>
				<p class="card-text"><%=
				n.getContent()
				%></p>
				<a href="DeleteServlet?n_id=<%= n.getId() %>" class="btn btn-denger">Delete</a>
				<a href="edit.jsp?n_id=<%=n.getId() %>" class="btn btn-primary">Update</a>
			</div>
		</div>

		<% 
			}
			s.close();
		%>
		
		
		</div>
		
  </div>
				
</div>
	

</body>
</html>