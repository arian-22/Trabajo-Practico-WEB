package juego;

import java.util.Random;

import database.DataPersonaje;
import entidades.Personaje;
import util.ApplicationException;

public class ControladorJuego { 
	
	Personaje jugador1;
	Personaje jugador2;
	private Partida partida; 
	
	


	public Personaje getJugador1() {
		return jugador1;
	}


	public void setJugador1(Personaje jugador1) {
		this.jugador1 = jugador1;
	}


	public Personaje getJugador2() {
		return jugador2;
	}


	public void setJugador2(Personaje jugador2) {
		this.jugador2 = jugador2;
	}



	
	
	public void agregarPersonaje(Personaje personaje) throws ApplicationException{
	
		DataPersonaje dbPersonaje = new DataPersonaje();
		
		Boolean ok = dbPersonaje.getByNombre(personaje.getNombre());
			
	
			if(ok){
				personaje.setPuntosTotales(200); //Cada vez que se agrega un nuevo personaje siempre tiene inicialmente 200 puntosTotales
				dbPersonaje.add(personaje);
			}else{
				throw (new ApplicationException());
			}
		
	}


	public Personaje buscarPersonaje(int idPersonaje) {
		
		Personaje p = new Personaje();
		
		DataPersonaje dbPersonaje = new DataPersonaje();	
		
		p = dbPersonaje.getById(idPersonaje);
		
		return p;
		
	}
	
	public void modificarPersonaje(Personaje p){
		DataPersonaje dbPersonaje = new DataPersonaje();	
		
		dbPersonaje.update(p);
	}

	public void cambiarTurno(){
		if(partida.getTurno().getIdPersonaje()==jugador1.getIdPersonaje()){
			partida.setTurno(jugador2);
		}else{
			partida.setTurno(jugador1);
		}
		
		
	}
	
	public void iniciarPartida(){
		partida = new Partida();
		partida.setCtrl(this);
		partida.inicializar();
	
	}
	
	public void sorteo(int op1,int op2){
		
		Boolean sale = true;
		
		Random rand = new Random();
		int aleatorio;
		
		do{
		
			aleatorio = rand.nextInt(5)+1; 
				
			
			if(op1 == aleatorio){
				
				partida.setTurno(jugador1);
				sale = false;
				
			}
			 else if(op2 == aleatorio){
				
				partida.setTurno(jugador2);
				
				sale = false;
				}
			
		}while(sale);
	}


	public Partida getPartida() {
		return partida;
	}
	
	public void actualizarGanador(Personaje p){
		
		DataPersonaje dbPersonaje = new DataPersonaje();
		
		dbPersonaje.update(p);
		
	}


	public void cleanJugadores() {
		
		jugador1 = null;
		jugador2 = null;
		
	}
	
		
}
