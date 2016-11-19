<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" %>
<%@ page import = "database.*"%>
<%@ page import = "java.sql.*"%> 
<%@ page import = "java.util.*"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Seleccionar Personajes</title>
		
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="">

	
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">

 	<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <script src="js/ie-emulation-modes-warning.js"></script>
	  
    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">
    
    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">
    
       
	</head>
	
	<body>
	
		  <% if (request.getAttribute("ganador")!=null && !((String)request.getAttribute("ganador")).isEmpty()){ %>
			<div class="alert alert-dismissable alert-danger alerta" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    			<span aria-hidden="true">&times;</span>
	  			</button>
	  
				<p><br><strong>Ganador: <h2><%=request.getAttribute("ganador") %></h2></strong></p>
				<p><br><strong>Seleccione los personajes nuevamente para continuar jugando</strong></p>
					
			</div>
		<%} %> 
		
		<h3 class="sub-header">Personajes Disponibles:</h3>
		 <div class="table-responsive">
            <table class="table table-striped">
				<thead>
                <tr>
                  <th>ID</th>
                  <th>Nombre</th>
                  <th>Vida</th>
                  <th>Defensa</th>
                  <th>Energía</th>
                  <th>Evasión</th>
                  <th>Pts. Totales</th>
                </tr>
              </thead>
			<tbody>
					<%
						DataPersonaje dbPersonaje = new DataPersonaje();
						
						ResultSet rs = dbPersonaje.gridPersonajes(); 
						while(rs.next()){
						   out.println("<tr>");
							   out.println("<td>"+rs.getInt("idPersonaje")+"</td>");
							   out.println("<td>"+rs.getString("nombre")+"</td>");
							   out.println("<td>"+rs.getInt("vida")+"</td>");
							   out.println("<td>"+rs.getInt("defensa")+"</td>");
							   out.println("<td>"+rs.getInt("energia")+"</td>");
							   out.println("<td>"+rs.getInt("evasion")+"</td>");
							   out.println("<td>"+rs.getInt("puntosTotales")+"</td>");
						   out.println("</tr>");
						   
						   
						}
					%>
					</tbody>
            </table>
          </div>
          
    
		
      <div class="container">

	      <form class="form-signin" name="signin" action="Start" method="post">
	       	<div class = "col-lg-6">
		       	<h3 class="form-signin-heading">Seleccionar su personaje</h3>
		        <label for="inputPersonaje1" class="sr-only">Personaje 1</label>
		        <input type="number" name="Personaje1" id="inputPersonaje1" class="form-control" placeholder="ID Personaje 1" required="">
		        <label for="inputPersonaje2" class="sr-only">Personaje 2</label>
		        <input type="number" name="Personaje2" id="inputPersonaje2" class="form-control" placeholder="ID Personaje 2" required="">
		     </div> 
		     
		     <div class = "col-lg-6">
		       <center>	<h4>Sorteo</h4>
		       	<p>Ingrese un número del 1 al 5</p></center>
		        <label for="inputPersonaje1" class="sr-only">Jugador 1</label>
		        <input type="text" pattern="[1-5]" name="op1" id="inputOp1" class="form-control" placeholder="Jugador 1" required="">
		        <label for="inputOp2" class="sr-only">Jugador 2</label>
		        <input type="text" pattern="[1-5]" name="op2" id="inputPersonaje2" class="form-control" placeholder="Jugador 2" required="">
		     </div> 
		       
	        
	        
	        <button class="btn btn-lg btn-primary btn-block" type="submit">Jugar</button>
	      </form>

    </div> <!-- /container -->
    
    <% if (request.getAttribute("error2")!=null && !((String)request.getAttribute("error2")).isEmpty()){ %>
		<div class="alert alert-dismissable alert-danger alerta" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
    			<span aria-hidden="true">&times;</span>
  			</button>
  
			<p><br><strong>Error: <%=request.getAttribute("error2") %></strong></p>
				
		</div>
	<%} %> 
	
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="js/vendor/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
    
	</body>
</html>


