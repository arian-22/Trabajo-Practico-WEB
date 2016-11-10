<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "entidades.*" %>
<%@ page import = "juego.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	    <meta name="description" content="">
	    <meta name="author" content="">
	    <link rel="icon" href="../../favicon.ico">
		
		<title>Turn Based Combat</title>
		
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet">
	
	    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	    <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">
	
	    <!-- Custom styles for this template -->
	    <link href="css/jumbotron-narrow.css" rel="stylesheet">
	
	    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
	    <script src="js/ie-emulation-modes-warning.js"></script>
	</head>
	
	<body >
				
		<center><h1> Turn Based Combat!</h1></center>
		
		<% 
			Personaje p1= ((Personaje)session.getAttribute("P1"));
			Personaje p2= ((Personaje)session.getAttribute("P2"));
			
			ControladorJuego ctrl = ((ControladorJuego)session.getAttribute("Ctrl"));
		%>
		
		<%= p1.getNombre() %>
		<br>
		<%= p2.getNombre() %>
		
				
		
		<p><br>Comienza Jugador: <%= ctrl.getPartida().getTurno().getNombre()  %></p>
		
		
    	<div class="container">
	    	<div class="row marketing">
		        <div class="col-xs-6 divide">
		          <h4><%= p1.getNombre() %></h4>
		          <div class="col-xs-6">
		          	<p>Vida: <%= p1.getVidaActual() %></p>
		          </div>
		          <div class="col-xs-6">
		          	<p>Energía: <%= p1.getEnergiaActual() %></p>
		          </div>
		        </div>
	
		        <div class="col-xs-6 divide">
		          <h4><%= p2.getNombre() %></h4>
		          <div class="col-xs-6">
		          	<p>Vida: <%= p2.getVidaActual() %></p>
		          </div>
		          <div class="col-xs-6">
		          	<p>Energía: <%= p2.getEnergiaActual() %></p>
		          </div>
		        </div>
	      </div>
	     </div>
		

		
	</body>
</html>