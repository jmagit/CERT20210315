package com.examples.domains.services;

import java.util.Collection;

import com.examples.contracts.AlumnoRepository;
import com.examples.contracts.AlumnoService;
import com.examples.entities.Alumno;
import com.examples.exception.CursoException;
import com.examples.repositories.AlumnoRepositoryImp;
import com.examples.repositories.AlumnoRepositoryMockImp;

public class AlumnoServiceImp implements AlumnoService {
	private AlumnoRepository dao = new AlumnoRepositoryMockImp();
	@Override
	public Collection<Alumno> get() {
		return dao.get();
	}

	@Override
	public Alumno get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Alumno item) throws CursoException, CloneNotSupportedException {
		// Validaciones
		dao.add(item);
	}

	@Override
	public void modify(Alumno item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		
	}

}
