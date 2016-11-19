package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.mysql.fabric.xmlrpc.base.Data;

import database.DataPersonaje;
import juego.*;
import util.ApplicationException;
import entidades.*;

/**
 * Servlet implementation class Start
 */
@WebServlet("/Start")
public class Start extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Start() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		
		ControladorJuego ctrl = new ControladorJuego();
		

		try{
			Personaje p1= new Personaje();
			p1 = ctrl.buscarPersonaje(Integer.parseInt(request.getParameter("Personaje1")));
			Personaje p2= new Personaje();
			p2 = ctrl.buscarPersonaje(Integer.parseInt(request.getParameter("Personaje2")));
			
			ctrl.setJugador1(p1);
			ctrl.setJugador2(p2);
			
			int op1 = Integer.parseInt(request.getParameter("op1"));
			int op2 = Integer.parseInt(request.getParameter("op2"));
			
			if((p1.getIdPersonaje() != p2.getIdPersonaje()) && (op1 != op2) ){
				
				ctrl.iniciarPartida();
				
				ctrl.sorteo(op1,op2);
			
				Partida partida = ctrl.getPartida();
				
				request.getSession().setAttribute("P1", p1);
				request.getSession().setAttribute("P2", p2);
				request.getSession().setAttribute("Ctrl", ctrl);
				request.getSession().setAttribute("Partida", partida);
				
				request.getRequestDispatcher("WEB-INF/play.jsp").forward(request, response);
			}else{
				String str= "No puede elegir el mismo personaje, ni el mismo número para el sorteo.";
				request.setAttribute("error2", str);
				request.getRequestDispatcher("iniciarJuego.jsp").forward(request, response);
			
			}			
		}catch(ApplicationException e){
			String str= "Elija un personaje válido de la lista.";
			request.setAttribute("error2", str);
			request.getRequestDispatcher("iniciarJuego.jsp").forward(request, response);
		}	
	
	}
}


