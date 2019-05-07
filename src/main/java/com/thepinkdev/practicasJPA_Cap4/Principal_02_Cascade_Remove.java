package com.thepinkdev.practicasJPA_Cap4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.thepinkdev.modelo.Alumno;

public class Principal_02_Cascade_Remove {
    
	public static void main( String[] args ) {
				
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadCurso");
    	EntityManager em = emf.createEntityManager();

    	Alumno pedro = em.find(Alumno.class, "1");
    	Alumno maria = em.find(Alumno.class, "2");
    	
    	em.getTransaction().begin();
    	
    		em.remove(pedro);
    		em.remove(maria);

	    em.getTransaction().commit();
    	
    	em.close();
    	emf.close();
    	
    }
}
