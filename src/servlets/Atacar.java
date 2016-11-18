package servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
	private int puntosAtaque;
	private int id;
       
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
		
		if( request.getParameter("PtsAtaquePersonaje1")!= null){
			puntosAtaque = Integer.parseInt(request.getParameter("PtsAtaquePersonaje1"));
			id = ctrl.getJugador1().getIdPersonaje();
		}else{
			if( request.getParameter("PtsAtaquePersonaje2")!= null){
				puntosAtaque = Integer.parseInt(request.getParameter("PtsAtaquePersonaje2"));
				id = ctrl.getJugador2().getIdPersonaje();
			}
		}
		
		if(partida.getTurno().getIdPersonaje() == id){
			try {
				partida.atacar(puntosAtaque);
				
				ctrl.cambiarTurno();	
				
				String str = partida.getTurno().getEstadoAtaque();
				request.setAttribute("evasion", str);
				
				if(ctrl.getPartida().getTurno().getVidaActual() <= 0){
					partida.finJuego();	
					String str2 = partida.getTurno().getNombre();
					request.setAttribute("ganador", str2);
					request.getRequestDispatcher("iniciarJuego.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("WEB-INF/play.jsp").forward(request, response);
				}
						
				
			}catch (ApplicationException e1) {
				String str = e1.errorPuntosDeAtaque();
				
				request.setAttribute("error", str);
				request.getRequestDispatcher("WEB-INF/play.jsp").forward(request, response);


			}
		}else{
			String str = "Turno del jugador "+partida.getTurno().getNombre();
			
			request.setAttribute("error3", str);
			request.getRequestDispatcher("WEB-INF/play.jsp").forward(request, response);
		}
		
		
		
		
	}

}
