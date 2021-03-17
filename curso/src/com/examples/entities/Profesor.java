package com.examples.entities;

import java.time.LocalDate;

public class Profesor extends Persona {

	public Profesor(int id, String nombre, String apellidos, LocalDate fechaNacimiento) {
		super(id, nombre, apellidos, fechaNacimiento);
	}

	public Profesor(int id, String nombre, String apellidos) {
		super(id, nombre, apellidos);
	}

	public void corregirExcamen() {

	}

	@Override
	public void comer() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
		// super.toString();
		return "Profesor [Id=" + getId() + ", Nombre=" + getNombre() + " " + getApellidos()
				+ "]";
	}
	@Override
	public void Pintate() {
		System.out.println(this);
		
	}

}
