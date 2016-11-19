package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import juego.*;

/**
 * Servlet implementation class Jugar
 */
@WebServlet("/Defensa")
public class Defensa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int id;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Defensa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		ControladorJuego ctrl = (ControladorJuego) request.getSession().getAttribute("Ctrl");
		Partida partida = (Partida) request.getSession().getAttribute("Partida");
		
		if( request.getParameter("defensaJugador1")!= null){
			id = ctrl.getJugador1().getIdPersonaje();
		}else{
			if( request.getParameter("defensaJugador2")!= null){
				id = ctrl.getJugador2().getIdPersonaje();
			}
		}
		
		if(partida.getTurno().getIdPersonaje() == id){
			partida.defender();
		
			ctrl.cambiarTurno();
		
			request.getRequestDispatcher("WEB-INF/play.jsp").forward(request, response);
		}else{
			String str = "Turno del jugador "+partida.getTurno().getNombre();
			
			request.setAttribute("error3", str);
			request.getRequestDispatcher("WEB-INF/play.jsp").forward(request, response);
		}

		
		
		
	}

}
