package com.examples;

import com.examples.utils.Autor;

@Autor(nombre = "Otro", apellidos = {"ejemplo", "de" , "anotacion" } )
public interface Validaciones {
	static boolean estaVacio(String cad) {
		return cad == null || "".equals(cad);
	}
	static boolean estaRelleno(String cad) {
		return !estaVacio(cad);
	}
	static boolean maxLength(String cad, int max) {
		return estaVacio(cad) || cad.length() <= max;
	}
	static boolean notMaxLength(String cad, int max) {
		return !maxLength(cad, max);
	}
}
