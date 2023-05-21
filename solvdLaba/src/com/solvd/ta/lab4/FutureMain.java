package com.solvd.ta.lab4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FutureMain {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		final Logger LOGGER = LogManager.getLogger(FutureMain.class);
		ConnectionPool pool = new ConnectionPool(5);
		ExecutorService ex = Executors.newFixedThreadPool(7);

		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() {
				try {
					Connection c = pool.getConnection();
					c.connect();
					Thread.sleep(1000);
					pool.releaseConnection(c);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return "Job done!";
			}
		};

		for (int i = 0; i < 7; i++) {
			Future<String> future = ex.submit(callable);
			while (!future.isDone()) {
				LOGGER.info("Not done!");
				Thread.sleep(1000);
			}
		}

		ex.shutdown();
	}

}
