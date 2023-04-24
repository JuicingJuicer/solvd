package com.solvd.ta.lab2;

import java.util.Random;
import java.util.Scanner;

public class Member {
	private String name;
	private int id;
	private boolean isRegistered = false;
	private Preferences preferences = new Preferences();

	Scanner sc = new Scanner(System.in);

	public Member() {
		Random rando = new Random();
		this.id = rando.nextInt(1000);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setID(int id) {
		this.id = id;
	}

	public void setIsRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}

	public String getName() {
		return this.name;
	}

	public int getId() {
		return this.id;
	}

	public boolean getIsRegistered() {
		return this.isRegistered;
	}

	public static void main(String[] args) {
		Member member = new Member();
		System.out.println(member.getName() + " " + member.getId());
	}
}
