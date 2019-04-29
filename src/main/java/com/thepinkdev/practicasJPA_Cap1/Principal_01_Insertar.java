package com.thepinkdev.practicasJPA_Cap1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.thepinkdev.modelo.Alumno;

public class Principal_01_Insertar {
    
	public static void main( String[] args ) {
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadCurso");
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction transaction = em.getTransaction();
    	
    	Alumno pedro = new Alumno("1", "Pedro", "Gómez", 30);
    	
    	transaction.begin();
    	em.persist(pedro);
    	transaction.commit();
    	em.close();
    	emf.close();
    	
    }
}
