package com.thepinkdev.practicasJPA_Cap4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.thepinkdev.modelo.Alumno;
import com.thepinkdev.modelo.Curso;

public class Principal_03_Cascade_Orphan_Removal {
    
	public static void main( String[] args ) {
				
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadCurso");
    	EntityManager em = emf.createEntityManager();

    	Curso java = em.find(Curso.class, "JAVA2");
    	Alumno pedro = em.find(Alumno.class, "1");
    	
    	em.getTransaction().begin();
    	
    		pedro.remove(java);

	    em.getTransaction().commit();
    	
    	em.close();
    	emf.close();
    	
    }
}
