package com.examples.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class Factura implements Cloneable {
	public static class DireccionFactura extends Direccion {
		
	}
	public class Linea implements Cloneable {
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
	private List<Linea> lineas = new CopyOnWriteArrayList<>();
	
	public List<Linea> getLineas() {
		return java.util.Collections.unmodifiableList(lineas);
	}
	
	public void SetNumFactura(int value) {
		if(numFactura == value) return;
		numFactura = value;
//		lineas.forEach(item -> item.SetNumFactura(value));
	}
	
	@Override
	public Factura clone() {
		Factura rslt = new Factura();
		rslt.numFactura = this.numFactura;
		if(lineas instanceof Cloneable)
			rslt.lineas = List.copyOf(lineas);
		return rslt;
	}
	
}
