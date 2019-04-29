package com.thepinkdev.practicasJPA_Cap1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.thepinkdev.modelo.Alumno;

public class Principal_03_Borrar {
    
	public static void main( String[] args ) {
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadCurso");
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction transaction = em.getTransaction();
    	
    	Alumno alumno = em.find(Alumno.class, "1");
    	System.out.println(alumno.getNombre());
    	
    	transaction.begin();
    	em.remove(alumno);
    	transaction.commit();
    	
    	em.close();
    	emf.close();
    	
    }
}
