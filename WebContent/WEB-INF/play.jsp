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
	
	<body class="fondo">
				
		<center><h1> Turn Based Combat!</h1></center>
		
		<% 
			Personaje p1= ((Personaje)session.getAttribute("P1"));
			Personaje p2= ((Personaje)session.getAttribute("P2"));
			
			ControladorJuego ctrl = ((ControladorJuego)session.getAttribute("Ctrl"));
			
			Partida partida = ctrl.getPartida();
		%>
		
		
		
		<div class="alert alert-dismissable alert-danger alerta">
				<p><br><strong>Turno jugador: <%= ctrl.getPartida().getTurno().getNombre()  %></strong></p> 	
		</div>
		

		<div class="row marketing">
			<!-- Columna Jugador 1 -->
	    	<div class="col-xs-6 divide">
	    		<strong><h4><%= p1.getNombre() %></h4></strong> 
		        <img alt="Imagen Jugador 1" src="http://lorempixel.com/140/140/" class="img-thumbnail" /><br><br>
		        
		        <div class="row">
			        <div class="col-xs-6">
			        	<p><strong>Vida:</strong> <%= p1.getVidaActual() %></p>
			        </div>
			        <div class="col-xs-6">
			        	<p><strong>Energía:</strong> <%= p1.getEnergiaActual() %></p>
			        </div>
		        </div>
		        
		        <div class="row">
		        	<div class="col-md-6">
		        		<form class="form-signin" name="ataque" action="Atacar" method="post">
		        			<label for="text" class="sr-only">Pts. Ataque</label>
			        		<input name="PtsAtaquePersonaje1" type="text" id="inputPtsAtaquePersonaje1" class="form-control" placeholder="Pts. Ataque" required autofocus>
					        <button type="submit" class="btn btn-default btn-block">Atacar</button>
		        		</form>
		        	</div>
		        	
		        	<div class="col-md-6">
		        		 <form class="form-signin" name="defensa" action="Defensa" method="post">
		        		 	<button type="submit" class="btn btn-block btn-default">Defender</button>
		        		 </form>
		        	</div>
		        </div>
		        
		        
	    	</div>
	    	
	    	
	    	<!-- Columna Jugador 2 -->
	    	<div class="col-xs-6 divide">
	    		 <strong><h4><%= p2.getNombre() %></h4></strong>
		         <img alt="Imagen Jugador 2" src="http://lorempixel.com/140/140/" class="img-thumbnail" /><br><br>
		         
		         <div class="row">
			        <div class="col-xs-6">
			        	<p><strong>Vida:</strong> <%= p2.getVidaActual() %></p>
			        </div>
			        <div class="col-xs-6">
			        	<p><strong>Energía:</strong> <%= p2.getEnergiaActual() %></p>
			        </div>
		        </div>
		        
		        <div class="row">
		        	<div class="col-md-6">
		        		<form class="form-signin" name="ataque" action="Atacar" method="post">
		        			<label for="text" class="sr-only">Pts. Ataque</label>
			        		<input name="PtsAtaquePersonaje1" type="text" id="inputPtsAtaquePersonaje1" class="form-control" placeholder="Pts. Ataque" required autofocus>
					        <button type="submit" class="btn btn-default btn-block">Atacar</button>
		        		</form>
		        	</div>
		        	
		        	<div class="col-md-6">
		        		 <form class="form-signin" name="defensa" action="Defensa" method="post">
		        		 	<button type="submit" class="btn btn-block btn-default">Defender</button>
		        		 </form>
		        	</div>
		        </div>
		        
		         
	    	</div>
	    		
		</div>
				
		
	</body>
</html>