package com.examples.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.examples.CursoException;
import com.examples.contracts.AlumnoRepository;
import com.examples.entities.Alumno;

//import com.examples.entities.Alumno;

public class AlumnoRepositoryMockImp implements AlumnoRepository {
	private static Map<Integer, Alumno> listaAlumnos;
	Object db;
	static {
		listaAlumnos = new HashMap<Integer, Alumno>();
		listaAlumnos.put(1, new Alumno(1, "Pepito", "Grillo", null));
		listaAlumnos.put(2, new Alumno(2, "Carmelo", "Coton", null));
	}

	public AlumnoRepositoryMockImp() {
		// db.open();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<Alumno> get() {
		// leer db
		return listaAlumnos.values();
	}

	@Override
	public Alumno get(int id) {
		// leer db
		return listaAlumnos.get(id);
	}
	
	@Override
	public void add(Alumno item) throws CursoException {
		if(item == null)
			throw new CursoException("El elemento no puede estar a nulo");
		try {
			listaAlumnos.put(item.getId(), item);
		} catch (Exception e) {
			throw new CursoException("Error al guardar", e);
		}
	}
	
	@Override
	public void modify(Alumno item) {
		listaAlumnos.replace(item.getId(), item);
	}
	
	@Override
	public void remove(int id) {
		listaAlumnos.remove(id);
	}
	
	@Override
	public void remove(Alumno item) {
		remove(item.getId());
	}
	
	@Override
	protected void finalize() throws Throwable {
		// db.close();
		// TODO Auto-generated method stub
		super.finalize();
	}
	
//	@Override
//	protected Object clone() {
//		try {
//			super.clone();
//		} catch (CloneNotSupportedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return super.clone();
//	}
}
