package com.solvd.ta.lab2.collections;

public class Node<T> {
	T data;
	Node<T> next;

	public Node(T data) {
		this.data = data;
		this.next = null;
	}
}
