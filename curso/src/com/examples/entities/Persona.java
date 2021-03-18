package com.examples.entities;

import java.time.LocalDate;
import java.util.Optional;

import javax.naming.OperationNotSupportedException;

import com.examples.CursoException;
import com.examples.Validaciones;
import com.examples.contracts.Grafico;

public abstract class Persona implements Grafico {
	private int id;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	
	transient private int edad;
	
	public Persona(int id, String nombre, String apellidos, LocalDate fechaNacimiento) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		if(fechaNacimiento != null)
			setFechaNacimiento(fechaNacimiento); 
	}
	
	public Persona(int id, String nombre, String apellidos) {
		this(id, nombre, apellidos, null);
	}

	public int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public boolean hayNombre(){
		return nombre != null;
	}
	public String getNombre() throws CursoException {
		if(nombre == null)
			throw new CursoException("No hay nombre");
		return nombre;
	}

	public void setNombre() {
		this.nombre = null;
	}
	public void setNombre(String nombre) {
		if(this.nombre == nombre) return;
		if(Validaciones.estaVacio(nombre)) {
			
		}
		this.nombre = nombre;
	}

	public Optional<String> getApellidos() {
		if(apellidos == null) 
			return Optional.empty();
		return Optional.of(apellidos);
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	//@Deprecated
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		assert fechaNacimiento != null : "Fecha a nulo";
//		assert fechaNacimiento.isBefore(LocalDate.now()) : "Fecha posterior";
		this.fechaNacimiento = fechaNacimiento;
		edad = LocalDate.now().getYear() - fechaNacimiento.getYear() - 
				(LocalDate.now().getDayOfYear() < fechaNacimiento.getDayOfYear() ? 1 : 0);
		assert edad >= 0 : "Edad negativa";
	}
	
	public int getEdad() throws OperationNotSupportedException {
		if(fechaNacimiento == null)
			throw new OperationNotSupportedException();
		return LocalDate.now().getYear() - fechaNacimiento.getYear() - 
				(LocalDate.now().getDayOfYear() < fechaNacimiento.getDayOfYear() ? 1 : 0);
	}
	
	private void privado() {}
	
	public abstract void comer();
}
