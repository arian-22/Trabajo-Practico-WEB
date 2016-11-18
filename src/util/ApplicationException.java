package util;

@SuppressWarnings("serial")
public class ApplicationException extends Exception{

	
	public ApplicationException(){
		super();
	}
	
	
	public String errorPuntosDeAtaque(){
		return "Ingrese un valor mayor a cero y menor o igual a la Energía";
	}
	


	public void errorDePuntajes() {
		// TODO Auto-generated method stub
		
	}
	
}
