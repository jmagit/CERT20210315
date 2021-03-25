package com.examples;

import java.lang.reflect.Method;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ServiceLoader;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import com.examples.types.Days;
import com.examples.types.Genero;
//import com.examples.entities.Asignatura;
import com.examples.entities.Elemento;
import com.examples.entities.Factura;
import com.examples.entities.Grafico;
import com.examples.entities.Persona;
import com.examples.entities.Profesor;
import com.examples.exception.CursoException;
import com.examples.contracts.AlumnoRepository;
import com.examples.contracts.AlumnoService;
import com.examples.contracts.Configuracion;
import com.examples.domains.services.AlumnoServiceImp;
import com.examples.entities.Alumno;

/**
 * Demo del curso
 * 
 * @author Javier
 * @version 1.0
 *
 */
public class Principal {
	public static final String TIPO = "kk";

	interface G1 extends Grafico {
		default void Pintate() {
			System.out.println("Uno");
		}
	}

	interface G2 extends Grafico {
		default void Pintate() {
			System.out.println("Dos");
		}
	}

	class Multiple implements G1, G2 {
		@Override
		public void Pintate() {
			// TODO Auto-generated method stub
			G1.super.Pintate();
		}
	}

	public static void main(String[] args) {
		ServiceLoader<Configuracion> services = ServiceLoader.load(Configuracion.class);
		services.forEach(srv -> srv.configurate("Soy el principal"));
		try {
			var clase = Class.forName("com.examples.uow.DataBase");
			Arrays.stream(clase.getDeclaredMethods()).forEach(m -> System.out.println(m.getName()));
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		AlumnoService srv = new AlumnoServiceImp();
		
		var lst = srv.get();
		try {
			srv.add(new Alumno(11, "Desde", "El modulo", null));
			lst.forEach(System.out::println);
		} catch (CursoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fin");
	}

}
