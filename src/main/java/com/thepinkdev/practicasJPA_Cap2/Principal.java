package com.thepinkdev.practicasJPA_Cap2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.thepinkdev.modelo.Alumno;
import com.thepinkdev.modelo.Curso;

public class Principal {

	public static void main(String[] args) {
		
		Alumno pedro = new Alumno("2", "Pedro", "Gómez", 30);
		Alumno maria = new Alumno("1", "María", "Pérez", 25);
		
		Curso cursoJava = new Curso("JAVA2", "Introducion a Java 2", 20, 300, pedro);
		Curso cursoNet = new Curso("NET2", "Introducion a NET 2", 20, 300, pedro);
		Curso cursoPHP = new Curso("PHP", "Introducion a PHP", 15, 250, maria);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadCurso");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
			em.persist(pedro);
			em.persist(maria);
			
			em.persist(cursoJava);
			em.persist(cursoNet);
			em.persist(cursoPHP);
			
			List<Curso> cursos = em.find(Alumno.class, "1").getCursos();
			for(Curso curso : cursos) {
				System.out.println(curso.getTitulo());
			}
			
		transaction.commit();
		
		em.close();
		emf.close();
		
		System.out.println("Terminado");
	}

}
