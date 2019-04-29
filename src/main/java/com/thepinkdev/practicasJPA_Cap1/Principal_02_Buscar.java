package com.thepinkdev.practicasJPA_Cap1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.thepinkdev.modelo.Alumno;

public class Principal_02_Buscar {
    
	public static void main( String[] args ) {
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadCurso");
    	EntityManager em = emf.createEntityManager();
    	
    	Alumno alumno = em.find(Alumno.class, "1");
    	System.out.println(alumno.getNombre());

    	em.close();
    	emf.close();
    	
    }
}
