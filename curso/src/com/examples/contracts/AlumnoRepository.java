package com.examples.contracts;

import java.util.Collection;

import com.examples.CursoException;
import com.examples.entities.Alumno;

public interface AlumnoRepository extends Repository<Alumno> {
	default void remove(Alumno item) { remove(item.getId()); };
}