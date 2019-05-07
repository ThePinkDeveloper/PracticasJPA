package com.thepinkdev.practicasJPA_Cap4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.thepinkdev.modelo.Alumno;
import com.thepinkdev.modelo.Curso;

public class Principal_01_Cascade_Persist {
    
	public static void main( String[] args ) {
    	
		Alumno pedro = new Alumno("1", "Pedro", "Gómez", 35);
		Alumno maria = new Alumno("2", "María", "Pérez", 25);
		
    	Curso cursoJava = new Curso("JAVA2", "Introducción a Java2", 20, 300, pedro);
    	Curso cursoNet = new Curso("NET2", "Introducción a Net2", 20, 300, pedro);
    	Curso cursoPhp = new Curso("PHP", "Introducción a PHP", 15, 250, maria);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadCurso");
    	EntityManager em = emf.createEntityManager();

    	pedro.add(cursoJava);
    	pedro.add(cursoNet);
    	maria.add(cursoPhp);
    	
    	em.getTransaction().begin();
    	em.persist(pedro);
    	em.persist(maria);
    	em.getTransaction().commit();
    	
    	em.close();
    	emf.close();
    	
    }
}
