package com.examples.entities;

import java.time.LocalDate;

import com.examples.exception.CursoException;

public class Alumno extends Persona {
	Asignatura[] asignaturas;
	
	public Alumno() {
		this(0, null, null, null);
	}
	public Alumno(int id, String nombre, String apellidos, LocalDate fechaNacimiento) {
		super(id, nombre, apellidos, fechaNacimiento);
		asignaturas = new Asignatura[10];
		asignaturas[0] = new Asignatura();
	}

	public void hacerExcamen() {
		for(var a: asignaturas) {
			
		}
	}
	@Override
	public void comer() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
		// super.toString();
		try {
			return "Alumno [Id=" + getId() + ", Nombre=" + (hayNombre() ? getNombre() : "") + " " + getApellidos()
					+ "]";
		} catch (CursoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	@Override
	public void Pintate() {
		System.out.println(this);
		
	}
	
	public Asignatura getAsignatura() {
		return asignaturas[0];
	}
	public void addAsignatura(int index, Asignatura asignatura) {
		asignaturas[index] = asignatura;
	}
}
