package com.examples;

import java.util.List;

public class Delegado {
	
	@FunctionalInterface
	public static interface Comparar<T> {
		int compara(T a, T b);
	}
	class OrdenDesc implements Comparar<String> {
		@Override
		public int compara(String a, String b) {
			return -a.compareTo(b);
		}
		
	}
	private List<String> lStrings;
	
	public static Comparar ASC = new Comparar<String>() {			
			@Override
			public int compara(String a, String b) {
				return a.compareTo(b);
			}
		};
	private Comparar desc;
	private static int i = -1;
	public void testOrdenar() {
		ordenar(new OrdenDesc());
		ordenar(String::compareTo);
		ordenar(new Comparar<String>() {			
			@Override
			public int compara(String a, String b) {
				return i * a.compareTo(b);
			}
		});
		this.i = 4;
		var otra = new Delegado();
		otra.i = 5;
		
		int ii = -1;
		ordenar(Delegado::unComparaDeClase);
		ordenar(this::unCompara);
		ordenar(new Comparar<String>() {			
			@Override
			public int compara(String a, String b) {
				return unCompara(a, b);
			}
		});
		
		ordenar(ASC);
		ordenar(new Comparar<String>() {			
			@Override
			public int compara(String a, String b) {
				return a.toLowerCase().compareTo(b.toLowerCase());
			}
		});
		Comparar<String> fn = (a, b) -> i * a.toLowerCase().compareTo(b.toLowerCase());
		ordenar(fn);
		desc = new Comparar<String>() {			
			@Override
			public int compara(String a, String b) {
				return ii * a.toLowerCase().compareTo(b.toLowerCase());
			}
		};
	}
	public int unCompara(String a, String b) {
		return a.toLowerCase().compareTo(b.toLowerCase());
	}
	public static int unComparaDeClase(String a, String b) {
		i = 0;
		return a.toLowerCase().compareTo(b.toLowerCase());
	}
	
	public void ordenar(Comparar<String> tipo) {
		String e1 = "", e2 = "";
		// ...		
		if(tipo.compara(e1, e2) < 0) {
			
		} else if(tipo.compara(e1, e2) == 0) {
			
		} else {
			
		}
		// ...		
	}

	/*
	enum Tipo { Asc, Desc, TextAsc };
	
	public void ordenar(Tipo tipo) {
		String e1 = "", e2 = "";
		// ...		
		switch (tipo) {
		case Tipo.Asc: 
			if(e1.compareTo(e2) < 0) {
				
			} else if(e1.compareTo(e2) == 0) {
				
			} else {
				
			}
			break;
		case Tipo.Desc: 
			if(e1.compareTo(e2) > 0) {
				
			} else if(e1.compareTo(e2) == 0) {
				
			} else {
				
			}
			break;
		}
		// ...		
	}
	*/
	/*
	public void ordenarDesc() {
		String e1 = "", e2 = "";
		// ...		
		if(e1.compareTo(e2) > 0) {
			
		} else if(e1.compareTo(e2) == 0) {
			
		} else {
			
		}
		// ...		
	}
	*/
}
