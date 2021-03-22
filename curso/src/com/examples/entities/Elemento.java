package com.examples.entities;

public class Elemento<K> {
	K key;
	String texto;
	public Elemento(K key, String texto) {
		this.key = key;
		this.texto = texto;
	}
	
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "Elemento [key=" + key + ", texto=" + texto + "]";
	}
	
}

/*
public class ElementoInt {
	int key;
	String texto;
}
public class ElementoChar {
	char key;
	String texto;
}
public class ElementoString {
	String key;
	String texto;
}
*/