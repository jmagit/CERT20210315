package com.examples;

import java.lang.reflect.Method;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.naming.OperationNotSupportedException;

import com.examples.types.Days;
import com.examples.types.Genero;
import com.examples.utils.Autor;
//import com.examples.entities.Asignatura;
import com.examples.entities.Elemento;
import com.examples.entities.Factura;
import com.examples.entities.Persona;
import com.examples.entities.Profesor;
import com.examples.repositories.AlumnoRepositoryImp;
import com.examples.repositories.AlumnoRepositoryMockImp;
import com.examples.contracts.AlumnoRepository;
import com.examples.contracts.Grafico;
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
		// TODO Auto-generated method stub
//		clases(1);
//		cambiaClases();
//		clases(2);
//		clases(1);
////		interfaces();
//		System.gc();
//		afirmaciones();
//		anotaciones();
		consultas();
	}

	static void consultas() {
		List<Persona> lista = List.of( 
					new Alumno(1, "Pepito", "Grillo", LocalDate.of(2000, 10, 10)), 
					new Profesor(2, "Profe", "Grillo", LocalDate.of(2002, 6, 1)),
					new Profesor(3, "Otro", "Profe", LocalDate.of(1985, 1, 1)),
					new Alumno(4, "Pedro", "Pica Piedra", LocalDate.of(2003, 7, 30)), 
					new Alumno(5, "Pablo", "Marmol", LocalDate.of(2000, 2, 28)));

		lista.stream()
			.filter(item -> item instanceof Profesor)
			.map(item -> (Profesor)item)
			.forEach(item -> System.out.println(item.getSalario()));
		lista.stream()
			.filter(item -> item instanceof Profesor)
			.peek(System.out::println)
			.map(item -> (Profesor)item)
			.forEach(item -> item.setSalario(item.getSalario() * 1.1));
//		lista.stream()
//			.filter(item -> item instanceof Profesor)
//			.map(item -> (Profesor)item)
//			.peek(item -> item.setSalario(item.getSalario() * 1.1))
//			.map(item -> item.getSalario())
//			.forEach(item -> System.out.println(item));
		lista.stream()
			.filter(item -> item instanceof Profesor)
			.map(item -> (Profesor)item)
			.forEach(item -> System.out.println(item.getSalario()));
		lista.stream()
			.forEach(item -> {
				try {
					System.out.println(item.getEdad());
				} catch (OperationNotSupportedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
		System.out.println(lista.stream()
			.filter(item -> {
				try {
					return item.getEdad() >= 18;
				} catch (OperationNotSupportedException e) {
					// TODO Auto-generated catch block
					return false;
				}
			})
			.map(item -> {				try {
				return item.getEdad();
			} catch (OperationNotSupportedException e) {
				// TODO Auto-generated catch block
				return 0;
			}})
			.distinct()
			.count()
			);
		try {
			System.out.println(lista.stream()
				.filter(item -> item instanceof Profesor)
				.map(item -> (Profesor)item)
				.max((a,b) -> (int)(a.getSalario() - b.getSalario()))
				.get()
				.getNombre()
			);
		} catch (CursoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			//.forEach(System.out::println);
		
		boolean soloAlumnos = false, paginado = false, mayores = false;
		int pag = 0, rows = 2;
		
		var query = dameConsulta(lista, soloAlumnos, paginado, mayores, pag, rows, null);
		
		query.forEach(System.out::println);
		System.out.println();
		query = dameConsulta(lista, true, true, mayores, pag, rows, (a, b) -> b.getId() - a.getId());
		query.forEach(System.out::println);
		System.out.println();
		query = dameConsulta(lista, true, true, mayores, 1, rows, (a, b) -> a.getId() - b.getId());
		query.forEach(System.out::println);
		
		query = dameConsulta(lista, true, paginado, true, pag, rows, null);
//		var p = query.findFirst();
//		System.out.println();
//		if(p.isPresent())
//			System.out.println(p);
		System.out.println();
		var l = query.collect(Collectors.toList());
		l.forEach(item -> System.out.println(item));
		System.out.println(lista.stream()
				.filter(item -> {
					try {
						return item.getEdad() < 18;
					} catch (OperationNotSupportedException e) {
						// TODO Auto-generated catch block
						return false;
					}
				})
				.count() > 0
				);
		System.out.println(lista.stream()
				.allMatch(item -> {
					try {
						return item.getEdad() >= 18;
					} catch (OperationNotSupportedException e) {
						// TODO Auto-generated catch block
						return false;
					}
				})
				);

		/*
		List<Integer> listOfIntegers = List.of(1, 5, 6, 7, 2, 3, 4, 8, 9);
		System.out.println("Sequential Stream: ");
		listOfIntegers.stream().map(item-> item * 2).sorted().forEach(e -> System.out.print(e + " "));
		System.out.println("\nParallel Stream: ");
		listOfIntegers.stream().parallel().map(item-> item * 2).sequential().sorted().forEach(e -> System.out.print(e + " "));
		 */
	}

	private static Stream<Persona> dameConsulta(List<Persona> lista, boolean soloAlumnos, boolean paginado,
			boolean mayores, int pag, int rows, Comparator<Persona> comp) {
		var query = lista.stream();
		if(soloAlumnos) {
			query = query.filter(item -> item instanceof Alumno);
		}
		if(mayores) {
			query = query.filter(item -> {
				try {
					return item.getEdad() >= 18;
				} catch (OperationNotSupportedException e) {
					// TODO Auto-generated catch block
					return false;
				}
			});
		}
		if(paginado) {
			query = query.sorted(comp)
					.skip(pag * rows)
					.limit(rows);
		}
		return query;
	}

		
	interface MiComparator<T> extends BiFunction<T, T, Integer> {
		
	}
	static void compara() {
		Factura f1 = new Factura();
		f1.SetNumFactura(111);
		Factura f2 = new Factura();
		f2.SetNumFactura(111);
		System.out.println("Son iguales:" + (f1 == f2 ? "SI" : "NO"));
		System.out.println("Son iguales:" + (f1.equals(f2) ? "SI" : "NO"));
		System.out.println("Son iguales:" + (f1.hashCode() == f2.hashCode() ? "SI" : "NO"));
		System.out.println("Son iguales:" + (f1.compareTo(f2) == 0 ? "SI" : "NO"));
		BiFunction<Factura, Factura, Integer> fn = (a, b) -> a.compareTo(b);
		Comparator<Factura> comparator = (a, b) -> a.compareTo(b);
		List<Factura> lst = new ArrayList<Factura>();
		lst.sort(comparator);
	}

	static void anidar() {
		Factura factura = new Factura();
		var dirF = new Factura.DireccionFactura();
		Object o = factura.clone();
		o = 4; // new Integer(4)
		int i = (int) o; // o.get()
		var s = "X";
		for (i = 0; i < 100; i++) {
			s += "X";
		}
		StringBuilder sb = new StringBuilder("X");
		for (i = 0; i < 100; i++) {
			sb.append("X");
		}
		s = sb.toString();

		// var linea = new factura.Linea();

	}

	static void anotaciones() {
		Class clase = Profesor.class;
		var anotaciones = clase.getAnnotations();
		System.out.println(Profesor.class.getAnnotation(Autor.class).nombre());

		try {
			clase = Class.forName("com.examples.entities.Persona");
			var m = clase.getMethods();
			var mp = clase.getDeclaredMethods();
			var p = new Profesor(1, "Profe", "Grillo", null);
			p.setFechaNacimiento(LocalDate.of(2020, 3, 18));
			Method metodo;
			metodo = p.getClass().getMethod("getEdad", null);
			System.out.println(metodo.invoke(p));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static void geneticos() {
		Elemento<Integer> provincia = new Elemento<Integer>(2, "Barcelona");
		provincia.setKey(1);
		Elemento<Character> genero = new Elemento<Character>('F', "Femenino");
		genero.setKey('k');
		if (genero instanceof Elemento) {
			var e = provincia;
		}
		kk(Elemento.class);

	}

	static <U> U kk(Class clase) {
//		clase.getConstructors()[0].newInstance(null)
		return null;
	}

	static void afirmaciones() {
		var p = new Profesor(1, "Profe", "Grillo", null);
//		p.setFechaNacimiento(null);
		p.setFechaNacimiento(LocalDate.of(2021, 3, 18));
	}

	static void interfaces() {
		Grafico[] lista = { new Alumno(1, "Pepito", "Grillo", null), new Profesor(1, "Profe", "Grillo", null)
				/*,
				new Asignatura()*/ };
		for (var g : lista)
			g.Pintate();
		var a = new Alumno(1, "Pepito", "Grillo", null);
		var aa = a.getAsignatura();
		a.addAsignatura(1, aa);
		Object o;
		var p = new Profesor(1, "Profe", "Grillo", null);
		try {
			var s = p.getNombre().toUpperCase();
			s = p.getApellidos().get();
			if (p.getApellidos().isPresent()) {
				s = p.getApellidos().get();
			}
		} catch (CursoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		o = new Profesor(1, "Profe", "Grillo", null);
		o = new Principal();

		if (o instanceof Grafico) {
			((Grafico) o).Pintate();
		}
	}

	static void clases(int id) {
		AlumnoRepository dao = new AlumnoRepositoryMockImp();
		Alumno item = dao.get(id);
		System.out.println(item);

	}

	static void cambiaClases() throws Exception {
		AlumnoRepository dao = new AlumnoRepositoryMockImp();
		dao.modify(new Alumno(1, "PEPITO", "Grillo", null));
		((AlumnoRepositoryMockImp) dao).filter(new Function<Alumno, Boolean>() {
			@Override
			public Boolean apply(Alumno t) {
				return t.getApellidos().isPresent() && t.getApellidos().get().startsWith("A");
			}
		});
		((AlumnoRepositoryMockImp) dao)
				.filter(t -> t.getApellidos().isPresent() && t.getApellidos().get().startsWith("A"));

		((AlumnoRepositoryMockImp) dao).filter(item -> {
			try {
				return item.getNombre().endsWith("o");
			} catch (CursoException e) {
				return false;
			}
		});
		Predicate<Alumno> fn = item -> item instanceof Alumno;
		fn.test(dao.get(0));

	}

	/**
	 * Demostración del JavaDoc
	 * 
	 * @param cad Literal con el valor numerico
	 * @return Valor entero del literal
	 * @throws InvalidParameterException Cadena nula o sin un valor númerico
	 */
	public int demo(String cad) throws InvalidParameterException {
		var x = new Principal();
		List<String> x2 = new ArrayList<>();
		var rslt = x.name();

		int[][] t = new int[3][5];
		t[0] = new int[10];
		t[1] = new int[2];
		// t[0] = t[1];
		var kk = t[0].length;
		t[0][0] = 4;
		if (t[1][0] == 4) {
			// ...
		}

		var aux = t[0];
		t[0] = t[1];
		t[1] = aux;
		if (t[0] == t[1]) {

		}
		boolean a = true, b = false;
		boolean c = a = b;
		if (t[1][1] == t[0][0] & a == b) {
			// ...
		}
		if (!a) {

		}
		String cmdSQL = "\tSelect *\n" + "\t from tabla\n" + "\t where 1=1";
		cmdSQL = """
				Select *
				from tabla
				where 1=1
				""";
		if (cmdSQL instanceof String) {
			String o = (String) cmdSQL;
			var i = o.length();
			// ... o
		}
		int i = 4 + (5 / (3 * 4));
		cmdSQL += "Fin";
		cmdSQL = cmdSQL + "Fin";

		switch (i) {
		case 1:
			// ...
		case 2:
			// ...
			break;
		default:
			// ...
			break;
		case 3, 4, 5:
			// ...
			break;
		}

		var j = switch (i) {
		case 1, 3, 5:
			yield "Uno";
		case 2, 4, 6:
			yield "Dos";
		default:
			yield "Muchos";
		} + " Algo";
		j = switch (i) {
		case 1, 3, 5 -> "Uno";
		case 2, 4, 6 -> "Dos";
		default -> "Muchos";
		} + " Algo";
		return 0b0110_1100_1001 | 0b011011001001;
	}

	public void tipos() {
		Genero g = Genero.FEMENINO;
		if (g == Genero.DESCONOCIDO) {

		}

		Days days = Days.MONDAY; // new Days(2)
		days = Days.getEnum(3);
		int i = days.getValue();
	}

	public int multihilo() {
		int[] t = { 1, 2, 3, 4, 5 };
		Integer rslt = 0;
		synchronized (rslt) {
			for (int i = 0; i < t.length; i++) {
				rslt += t[i];
			}
			return rslt;
		}
	}

	public List name() {
		return new ArrayList<String>();
	}
}
