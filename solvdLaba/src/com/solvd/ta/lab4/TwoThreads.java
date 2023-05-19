package com.solvd.ta.lab4;

public class TwoThreads {
	public static void main(String[] args) {
		Thread thread1 = new Thread(new RunnerThread("Chicken"));
		Thread thread2 = new Thread(new RunnerThread("Nuggets"));
		thread1.start();
		thread2.start();

		Thread thread3 = new Thread(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("BANG!");
		});

		Thread thread4 = new Thread(() -> System.out.println("Is this the dagger?"));

		thread3.start();
		thread4.start();
	}
}