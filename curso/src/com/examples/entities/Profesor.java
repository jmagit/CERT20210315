package com.examples.entities;

import java.time.LocalDate;

import com.examples.CursoException;
import com.examples.utils.Autor;

@Autor(nombre = "Yo mismo")
public class Profesor extends Persona {
	private double salario;
	public Profesor(int id, String nombre, String apellidos, LocalDate fechaNacimiento) {
		super(id, nombre, apellidos, fechaNacimiento);
		salario = nombre.hashCode() % 10000;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
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
		try {
			return "Profesor [Id=" + getId() + ", Nombre=" + (hayNombre() ? getNombre() : "") + " " + getApellidos()
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

}
