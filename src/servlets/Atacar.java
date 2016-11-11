package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ApplicationException;
import juego.ControladorJuego;
import juego.Partida;

/**
 * Servlet implementation class Atacar
 */
@WebServlet("/Atacar")
public class Atacar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Atacar() {
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
		
		int puntosAtaque = Integer.parseInt(request.getParameter("PtsAtaquePersonaje1"));
		
		try {
			partida.atacar(puntosAtaque);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(ctrl.getJugador1().getVidaActual() <= 0){
			//finJuego();					
		}else{
			//Despues de realizar todo, cambiar de panel
			ctrl.cambiarTurno();
}
	}

}
