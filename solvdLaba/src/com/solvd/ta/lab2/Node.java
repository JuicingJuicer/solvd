package com.solvd.ta.lab2;

public class Node<T> {
	T data;
	Node<T> next;

	Node(T data) {
		this.data = data;
		this.next = null;
	}
}
