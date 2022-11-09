package ejercicioFinal.inicio;

import java.util.List;

import ejercicioFinal.entidades.Guerrero;
import ejercicioFinal.interfaces.IGuerreroLucha;
import ejercicioFinal.interfaces.IGuerreroLuchaImpl;
import ejercicioFinal.repositorios.RepositorioGuerrero;
import ejercicioFinal.repositorios.RepositorioGuerreroImpl;

public class PrincipalLucha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PrincipalLucha p = new PrincipalLucha();
		p.mostrarGuerreros();
		p.iniciaGuerra();
	}
	

	private void mostrarGuerreros() {
		RepositorioGuerrero<Guerrero> repoGuerrero = new RepositorioGuerreroImpl();
		List<Guerrero> listaGuerreros = repoGuerrero.listarGuerreros();
		System.out.println("\n\t\t\t--- Listado de guerreros ----");
		for(Guerrero g : listaGuerreros) {
			System.out.println(" - " + g);
		}
	}
	
	private void iniciaGuerra() {
		int numAleatorio = 0;
		numAleatorio = (int) (Math.random() * (7 - 0) + 0);
		double valorDelAtaque =0;
		
		IGuerreroLucha turnoGuerrero = new IGuerreroLuchaImpl();

		if(numAleatorio % 2  == 1) {
			valorDelAtaque = turnoGuerrero.atacar(1);
			turnoGuerrero.defender(valorDelAtaque, 2);
		}
		if(numAleatorio % 2  == 0) {
			valorDelAtaque = turnoGuerrero.atacar(2);
			turnoGuerrero.defender(valorDelAtaque, 1);
		}
		
	}

}
