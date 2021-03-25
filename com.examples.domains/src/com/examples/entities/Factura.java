package com.examples.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class Factura implements Cloneable, Comparable<Factura> {
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
	
	public int getNumFactura() {
		return numFactura;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numFactura;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Factura))
			return false;
		return numFactura == ((Factura) obj).numFactura;
	}

	@Override
	public int compareTo(Factura o) {
		return numFactura - o.numFactura;
	}
	
}
