<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" %>
<%@ page import = "database.*"%> 
<%@ page import = "java.sql.ResultSet"%> 
<%@ page import = "java.util.*"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Seleccionar Personajes</title>
	</head>
	
	<body>
		<table border="1">
		<tr>
		<td>ID</td>
		<td>Nombre</td>
		<td>Pts. Totales</td>
		</tr>
		<%
			DataPersonaje dbPersonaje = new DataPersonaje();
			
			ResultSet rs = dbPersonaje.gridPersonajes(); 
			
			while(rs.next()){
			   out.println("<tr>");
			   out.println("<td>"+rs.getInt("idPersonaje")+"</td>");
			   out.println("<td>"+rs.getString("nombre")+"</td>");
			   out.println("<td>"+rs.getInt("puntosTotales")+"</td>");
			   out.println("</tr>");
			}
		%>
		</table>
	
	</body>
</html>


