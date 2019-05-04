package com.thepinkdev.practicasJPA_Cap3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.thepinkdev.modelo.Alumno;
import com.thepinkdev.modelo.Curso;

public class Principal_03_JPQL {
    
	public static void main( String[] args ) {
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadCurso");
    	EntityManager em = emf.createEntityManager();

    	TypedQuery<Alumno> consultaAlumnos = em.createQuery("SELECT a FROM Alumno a WHERE a.nombre = :nombre", Alumno.class);
    	consultaAlumnos.setParameter("nombre", "pedro");
    	
    	for (Alumno a: consultaAlumnos.getResultList()) {
    		System.out.println(a.getNombre());
    		for (Curso c: a.getCursos()) {
    			System.out.println(c.getTitulo());
    		}
    	}
    	
    	em.close();
    	emf.close();
    	
    }
}
