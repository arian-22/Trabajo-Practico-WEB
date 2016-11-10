package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import juego.*;
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
		
		Personaje p1= new Personaje();
		p1 = ctrl.buscarPersonaje(Integer.parseInt(request.getParameter("Personaje1")));
		Personaje p2= new Personaje();
		p2 = ctrl.buscarPersonaje(Integer.parseInt(request.getParameter("Personaje2")));
		
		ctrl.setJugador1(p1);
		ctrl.setJugador2(p2);
		
		ctrl.iniciarPartida();

		ctrl.sorteo(Integer.parseInt(request.getParameter("op1")),Integer.parseInt(request.getParameter("op2")));
		
		request.getSession().setAttribute("P1", p1);
		request.getSession().setAttribute("P2", p2);
		request.getSession().setAttribute("Ctrl", ctrl);
		
		request.getRequestDispatcher("WEB-INF/play.jsp").forward(request, response);
		
		
	}

}
