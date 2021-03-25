package com.examples.contracts;

import com.examples.entities.Alumno;

public interface AlumnoService extends DomainService<Alumno> {
	default void remove(Alumno item) { remove(item.getId()); };
}