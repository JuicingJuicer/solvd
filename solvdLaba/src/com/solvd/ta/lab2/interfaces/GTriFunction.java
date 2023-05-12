package com.solvd.ta.lab2.interfaces;

@FunctionalInterface
public interface GTriFunction<T, A, B> {
	T action(A x, B y);
}
