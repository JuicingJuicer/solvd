package com.solvd.ta.lab2.interfaces;

import java.util.ArrayList;

@FunctionalInterface
public interface GSearch<T> {
	T search(T item, ArrayList<T> items);
}
