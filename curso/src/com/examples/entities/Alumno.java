package com.examples.entities;

import java.time.LocalDate;

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
		return "Alumno [Id=" + getId() + ", Nombre=" + getNombre() + " " + getApellidos()
				+ "]";
	}
	@Override
	public void Pintate() {
		System.out.println(this);
		
	}
	
	
}
