package com.thepinkdev.practicasJPA_Cap1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.thepinkdev.modelo.Alumno;

public class Principal_04_Actualiza {
    
	public static void main( String[] args ) {
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadCurso");
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction transaction = em.getTransaction();
    	
    	Alumno alumno = new Alumno();
    	alumno.setDni("1");
    	alumno.setNombre("Pedro");
    	alumno.setApellidos("Gómez");
    	alumno.setEdad(30);
    	
    	transaction.begin();
    	Alumno nuevoAlumno = em.merge(alumno);
    	nuevoAlumno.setNombre("Juan");
    	transaction.commit();
    	
    	em.close();
    	emf.close();
    	
    }
}
