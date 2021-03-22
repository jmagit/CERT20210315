package com.examples.entities;

import java.util.List;

public class Factura {
	public static class DireccionFactura extends Direccion {
		
	}
	public class Linea {
		private int cantidad;
		private double precio;
		
		public int getNumFactura() {
			return numFactura;
		}
		
//		public void SetNumFactura(int value) {
//			if(numFactura == value) return;
//			numFactura = value;
//		}
//		
//		private int numFactura;
//		
//		private Linea(int numFactura) {
//			this.numFactura = numFactura;
//		}
		
	}
	private int numFactura;
	private List<Linea> lineas;
	
	public List<Linea> getLineas() {
		return lineas;
	}
	
	public void SetNumFactura(int value) {
		if(numFactura == value) return;
		numFactura = value;
//		lineas.forEach(item -> item.SetNumFactura(value));
	}
	
}
