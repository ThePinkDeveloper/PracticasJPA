package com.thepinkdev.practicasJPA_Cap3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.thepinkdev.modelo.Alumno;

public class Principal_05_JPQL {
    
	public static void main( String[] args ) {
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadCurso");
    	EntityManager em = emf.createEntityManager();

    	TypedQuery<Alumno> consultaAlumnos = em.createQuery("SELECT a FROM Alumno a JOIN a.cursos c WHERE c.id = :id", Alumno.class);
    	consultaAlumnos.setParameter("id", "JAVA2");
    	
    	for (Alumno a: consultaAlumnos.getResultList()) {
    		System.out.println(a.getNombre());
    	}
    	
    	
    	em.close();
    	emf.close();
    	
    }
}
