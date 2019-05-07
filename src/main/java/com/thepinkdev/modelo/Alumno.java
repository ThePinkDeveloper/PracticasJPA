package com.thepinkdev.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Alumno implements Serializable{

	private static final long serialVersionUID = 1L;

	// Propiedades
	
	@Id
	private String dni;
	private String nombre;
	private String apellidos;
	private Integer edad;
	
	/* Cascade Persist, Remove, orphanRemoval
	@OneToMany(mappedBy="alumno", 
			   cascade={CascadeType.PERSIST,
			            CascadeType.REMOVE},
			   orphanRemoval=true)
	private List<Curso> cursos = new ArrayList<Curso>();
	*/
	
	/* Solo Cascade Persist */
	@OneToMany(mappedBy="alumno", 
			   cascade={CascadeType.PERSIST})
	private List<Curso> cursos = new ArrayList<Curso>();
	
	// Constructores
	
	public Alumno() {
		super();
	}
	
	public Alumno(String dni, String nombre, String apellidos, Integer edad) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}
	
	// Setters y Getters

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	public void add(Curso c) {
		cursos.add(c);
		c.setAlumno(this);	
	}
	
	public void remove(Curso c) {
		cursos.remove(c);
		c.setAlumno(null);	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}	
}
