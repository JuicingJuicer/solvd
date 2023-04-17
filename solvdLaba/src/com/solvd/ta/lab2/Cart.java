package com.solvd.ta.lab2;

public class Cart extends Storage {
	private int count;

	public Cart() {
		this.count = 0;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return this.count;
	}
}
