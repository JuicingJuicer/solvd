package com.solvd.ta.lab4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Multi {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ConnectionPool pool = new ConnectionPool(5);
		ConnectionPool pool2 = new ConnectionPool(5);
		ExecutorService ex = Executors.newFixedThreadPool(7);
		ExecutorService ex2 = Executors.newFixedThreadPool(7);
		Runnable task = new Runnable() {
			@Override
			public void run() {
				try {
					Connection c = pool.getConnection();
					c.connect();
					Thread.sleep(1555);
					System.out.println("Job done!");
					pool.releaseConnection(c);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		for (int i = 0; i < 7; i++) {
			ex.execute(task);
		}

		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() {
				try {
					Connection c = pool2.getConnection();
					c.connect();
					Thread.sleep(1000);
					pool2.releaseConnection(c);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return "Job done!";
			}
		};

		for (int i = 0; i < 7; i++) {
			Future<String> future = ex2.submit(callable);
			while (!future.isDone()) {
				System.out.println("Not done!");
				Thread.sleep(500);
			}
		}
	}
}
