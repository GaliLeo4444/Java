package Objetos;
import java.util.LinkedList;


public class Almacenamiento {


// 	Atributos	

	private LinkedList<CD> ListaCDs;
	private int pos;


//	Constructor

	public Almacenamiento() {
		super();
		this.ListaCDs = new LinkedList<CD>();
	}


// 	Comandos

	public void AgregarCD(CD disco){
		ListaCDs.add(disco); // agrega al final de la lista	
	}

	public void QuitarCD(CD disco){
		ListaCDs.remove (disco);	
	}
	
	public void PrimerCD() {
		pos = 0;
	}
	
	public void SiguienteCD() {
		pos = pos + 1;		
	} 
	
	public void AnteriorCD() {
		pos = pos - 1;	
	}


//	Consultas

	public boolean ExisteCD(){
		return (ListaCDs.size() > pos);
	}
	
	public CD RetornarCD() {
		return ListaCDs.get(pos);
	}

	public boolean AlmacenamientoVacio(){
		return (ListaCDs.size() == 0);
	}
	
	public CD BuscarCD(String nombreCD) {
		int pista = 0;
		int cant;
		CD actualCD = null;
	
		cant = ListaCDs.size();
		while (pista < cant) {
			actualCD = ListaCDs.get(pista);
			if (nombreCD == actualCD.getNombre())
				{return actualCD;}
			else {pista += 1;}
		}
		if (pista == cant)
			{actualCD=null;}
		return actualCD;
	}


}


