package util;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class ApplicationException extends Exception{

	
	public ApplicationException(){
		super();
	}
	
	public void errorDePuntajes(){
		JOptionPane.showMessageDialog(null, "Puntos incorrectos!  Ingrese un numero mayor o igual a cero", 
				"Error. Vuelva a intentar", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void errorPuntosDeAtaque(){
		JOptionPane.showMessageDialog(null, "Ingrese un valor mayor a cero y menor o igual a la Energía", 
				"Error. Vuelva a intentar", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void errorNombrePersonaje(){
		JOptionPane.showMessageDialog(null, "Nombre ingresado ya existe. Por favor, ingrese otro.", 
				"Error. Vuelva a intentar", JOptionPane.INFORMATION_MESSAGE);
	}

	public void excedeLimitePtsTotales() {
		JOptionPane.showMessageDialog(null, "La suma total de los atributos del personaje, no deben superar los 200 puntos.", 
				"Error. Vuelva a intentar", JOptionPane.INFORMATION_MESSAGE);
		
	}

	public void fueraDeRango() {
		JOptionPane.showMessageDialog(null, "Los valores no deben repetirse y deben estar entre 1 y 5", 
				"Error. Vuelva a intentar", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
}
