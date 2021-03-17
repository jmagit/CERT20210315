package com.examples.contracts;

import java.util.Collection;

import com.examples.entities.Alumno;

public interface AlumnoRepository {

	Collection<Alumno> get();

	Alumno get(int id);

	void add(Alumno item);

	void modify(Alumno item);

	void remove(int id);

	default void remove(Alumno item) { remove(item.getId()); };

}