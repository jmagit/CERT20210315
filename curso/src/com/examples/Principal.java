package com.examples;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Demo del curso
 * 
 * @author Javier
 * @version 1.0
 *
 */
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
		// t[0].length
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
		j = switch (i) { case 1, 3, 5 ->"Uno"; case 2, 4, 6 -> "Dos"; default -> "Muchos"; } + " Algo";
		return 0b0110_1100_1001 | 0b011011001001;
	}

	public List name() {
		return new ArrayList<String>();
	}
}
