package ejercicioFinal.repositorios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import ejercicioFinal.entidades.Guerrero;
import ejercicioFinal.util.JpaUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class RepositorioGuerreroImpl implements RepositorioGuerrero<Guerrero>{
	
	private static final Logger logger = LogManager.getLogger(RepositorioGuerreroImpl.class);
	 //EntityManager em = JpaUtil.getEntityManager();
	
	
	@Override
	public Guerrero buscarGuerreroPorId(int idGuerrero) {
		// TODO Auto-generated method stub
	     	System.out.println(idGuerrero);
	     	EntityManager em = JpaUtil.getEntityManager();
	     	Guerrero guerrero =new Guerrero();
			 try {
				 logger.debug("----> Buscando al guerrero <----");
				 guerrero = em.find(Guerrero.class,idGuerrero);
			  
			 logger.debug("--->Finalizando busqueda de guerrero <---"); } catch (Exception
			 e) { // TODO Auto-generated catch block
			 logger.debug("----->Error al encontrar al guerrero <----" + e.getMessage());
			  } em.close();
			 
			
			/*
			 * Query query = em.createQuery("from Guerrero g where g.id=?1",
			 * Guerrero.class); query.setParameter(1, idGuerrero); query.setMaxResults(1);
			 * Guerrero guerrero = (Guerrero) query.getSingleResult();
			 * System.out.println(guerrero); em.close();
			 */
	return guerrero;
	
	
	}

	//------------------------------------------------------
	//Busco al guerrero por ID y modifico sus puntos de vida
	@Override
	public void quitarPuntosVidaGuerrero(int idGuerrero,double puntos) {
		// TODO Auto-generated method stub
		EntityManager em = JpaUtil.getEntityManager();
		try {
		Guerrero guerrero = em.find(Guerrero.class, idGuerrero);
        em.getTransaction().begin();
        guerrero.setPuntosVida(puntos);
        em.merge(guerrero);
        em.getTransaction().commit();
        logger.debug("-----> Los puntos de vida del "+ guerrero.getNombre()+ " se han modificado <-----" );

    } catch (Exception e) {
        em.getTransaction().rollback();
        logger.debug("-----> Error modificando los puntos de vida del guerrero <-------" + e.getMessage());
    } finally {
        em.close();
    }

		
	}

	@Override
	public List<Guerrero> listarGuerreros() {
		// TODO Auto-generated method stub
		EntityManager em = JpaUtil.getEntityManager();
		List<Guerrero> guerreros = new ArrayList<> ();
		try {
			logger.debug("---> Listando los guerreros <----");
			
			guerreros = em.createQuery("SELECT g from Guerrero g", Guerrero.class).getResultList();
			em.close();
			logger.debug("----> Finalizando el listando de guerreros <----");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			  logger.debug("-----> Error al listar los guerreros <-------" + e.getMessage());
		}
		return guerreros;
	}

}
