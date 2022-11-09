package ejercicioFinal.interfaces;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ejercicioFinal.entidades.Guerrero;
import ejercicioFinal.repositorios.RepositorioGuerrero;
import ejercicioFinal.repositorios.RepositorioGuerreroImpl;

public class IGuerreroLuchaImpl implements IGuerreroLucha {

	RepositorioGuerrero RepoGuerrero = new RepositorioGuerreroImpl();
	private static final Logger logger = LogManager.getLogger(IGuerreroLuchaImpl.class);
	
	//mediante el ID del guerrero lo buscare en la base de datos, para obtener sus puntos de ataque
	@Override
	public double atacar(int idGuerrero) {
		// TODO Auto-generated method stub
		double puntosAtaque = 0;
		int numAleatorio = 0;
		double valorAtacar = 0;
		logger.debug("-----> Entrando en el metodo atacar <-----" );
		try {
		
			Guerrero guerreroLucha = RepoGuerrero.buscarGuerreroPorId(idGuerrero);
			System.out.println(guerreroLucha.getPuntosAtaque());
			puntosAtaque = guerreroLucha.getPuntosAtaque();
			logger.debug(">>> Nombre : "+ guerreroLucha.getNombre() + "- puntos de ataque "+ guerreroLucha.getPuntosAtaque());
			numAleatorio = (int) (Math.random() * (11 - 0) + 0);
			valorAtacar = puntosAtaque * numAleatorio;
			logger.debug(">>>Los puntos con los que atacara el " + guerreroLucha.getNombre() + " son : " + valorAtacar);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.debug("----> Error en el metodo atacar <-----" + e.getMessage());
		}
		return valorAtacar;
	}

	@Override
	public double defender(double valorAtaque,int idGuerrero) {
		// TODO Auto-generated method stub
		double restarPuntosVida =0;
		double numAleatorio=0;

		logger.debug("-----> Entrando en el metodo defender <-----");
		try {
			Guerrero guerreroDefiende = RepoGuerrero.buscarGuerreroPorId(idGuerrero);
			logger.debug(">>>El guerrero que se va a defender es : "+ guerreroDefiende.getNombre());
			numAleatorio = Math.random() * (6 - 0) + 0;
			restarPuntosVida = valorAtaque - (guerreroDefiende.getPuntosDefensa() * numAleatorio);
			if (restarPuntosVida > 0) {
				logger.debug(">>>Los puntos de vida que se le van a quitar son : " + restarPuntosVida);
				RepoGuerrero.quitarPuntosVidaGuerrero(idGuerrero, restarPuntosVida);
				Guerrero g = RepoGuerrero.buscarGuerreroPorId(idGuerrero);
				logger.debug(">>>Los puntos de vida que le quedan son : " + g.getPuntosVida());
			} else {
				logger.debug(">>>El " + guerreroDefiende.getNombre() + " no perdio puntos de vida");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.debug("----> Error en el metodo denfender <-----" + e.getMessage());
		}
		
		return restarPuntosVida;
	}

}
