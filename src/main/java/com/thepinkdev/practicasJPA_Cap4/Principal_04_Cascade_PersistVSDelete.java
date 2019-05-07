package com.thepinkdev.practicasJPA_Cap4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.thepinkdev.modelo.Curso;

public class Principal_04_Cascade_PersistVSDelete {
    
	public static void main( String[] args ) {
				
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadCurso");
    	EntityManager em = emf.createEntityManager();

    	Curso java = em.find(Curso.class, "JAVA2");
    	
    	em.getTransaction().begin();
    	
    		em.remove(java);

	    em.getTransaction().commit();
    	
    	em.close();
    	emf.close();
    	
    }
}
