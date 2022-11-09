package ejercicioFinal.repositorios;



import java.util.List;

import ejercicioFinal.entidades.Guerrero;

public interface RepositorioGuerrero<T> {

	Guerrero buscarGuerreroPorId(int idGuerrero) ;
	
	void quitarPuntosVidaGuerrero(int idGuerrero,double puntos);
	List<Guerrero> listarGuerreros();
}
