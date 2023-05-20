package com.solvd.ta.lab4;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Multi {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		final Logger LOGGER = LogManager.getLogger(Multi.class);
		ConnectionPool pool = new ConnectionPool(5);
		ExecutorService ex = Executors.newFixedThreadPool(7);
		Runnable task = new Runnable() {
			@Override
			public void run() {
				try {
					Connection c = pool.getConnection();
					c.connect();
					Thread.sleep(2000);
					LOGGER.info("Job done!");
					pool.releaseConnection(c);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		for (int i = 0; i < 7; i++) {
			ex.execute(task);
		}

		ex.shutdown();
	}
}
