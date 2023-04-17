package com.solvd.ta.lab2;

import java.util.Random;
import java.util.Scanner;

public class Member {
	private String name;
	private int id;

	Scanner sc = new Scanner(System.in);

	public Member() {
		System.out.println("Enter your name:");
		// user input
		this.name = sc.nextLine();
		Random rando = new Random();
		this.id = rando.nextInt(100);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public int getId() {
		return this.id;
	}
}
