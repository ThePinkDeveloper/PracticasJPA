package com.thepinkdev.practicasJPA_Cap3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.thepinkdev.modelo.Alumno;
import com.thepinkdev.modelo.Curso;

public class Principal_07_JPQL {
    
	public static void main( String[] args ) {
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadCurso");
    	EntityManager em = emf.createEntityManager();

    	Query suma = em.createQuery("SELECT SUM(c.precio) FROM Curso c");
    	Long total = (Long) suma.getSingleResult();
    	System.out.println(total);
    	
    	em.close();
    	emf.close();
    	
    }
}
