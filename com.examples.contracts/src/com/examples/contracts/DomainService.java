package com.examples.contracts;

import java.util.Collection;

import com.examples.exception.CursoException;

public interface DomainService<T> {

	Collection<T> get();

	T get(int id);

	void add(T item) throws CursoException, CloneNotSupportedException;

	void modify(T item);

	void remove(int id);

	void remove(T item);

}