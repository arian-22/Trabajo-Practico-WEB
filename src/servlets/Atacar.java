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
			
			ctrl.cambiarTurno();	
			
			if(ctrl.getPartida().getTurno().getVidaActual() <= 0){
				partida.finJuego();	
				request.getRequestDispatcher("index.html").forward(request, response);
			}else{
				request.getRequestDispatcher("WEB-INF/play.jsp").forward(request, response);
			}
				
		}catch(NumberFormatException ne){
			String str = "Por favor ingrese un número";
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('"+str+"');");
			out.println("</script>");
			
		}catch (ApplicationException e1) {
			String str = e1.errorPuntosDeAtaque();
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('"+str+"');");
			out.println("</script>");

		}
		
		
		
	}

}
