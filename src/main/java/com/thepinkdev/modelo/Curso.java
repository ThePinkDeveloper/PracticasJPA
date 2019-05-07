package com.thepinkdev.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Curso implements Serializable{

	private static final long serialVersionUID = 1L;

	// Propiedades
	
	@Id
	private String id;
	
	private String titulo;
	private Integer duracion;
	private Integer precio;
	
	@ManyToOne
	@JoinColumn(name="alumno_dni")
	private Alumno alumno;
	
	// Constructores
	
	public Curso() {
		super();
	}
	
	public Curso(String id, String titulo, Integer duracion, Integer precio, Alumno alumno) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.duracion = duracion;
		this.precio = precio;
		this.alumno = alumno;
		setAlumno(alumno);
	}
	
	// Getters y Setters

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
		if (alumno != null) {
			alumno.getCursos().add(this);
		}
	}
	
	
	
	
}
