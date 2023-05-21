package com.solvd.ta.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CompletableFutureMain {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		final Logger LOGGER = LogManager.getLogger(CompletableFutureMain.class);
		ConnectionPool pool = new ConnectionPool(5);
		ExecutorService ex = Executors.newFixedThreadPool(7);
		ArrayList<CompletableFuture<String>> cfs = new ArrayList<CompletableFuture<String>>();

		for (int i = 0; i < 7; i++) {
			CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
				try {
					Connection c = pool.getConnection();
					c.connect();
					Thread.sleep(1000);
					pool.releaseConnection(c);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return "Thread: " + Thread.currentThread().getName() + " finished";
			}, ex);
			cfs.add(cf);
		}

		CompletableFuture<Void> doneCf = CompletableFuture.allOf(cfs.toArray(new CompletableFuture[cfs.size()]));
		CompletableFuture<List<String>> result = doneCf
				.thenApply(cf -> cfs.stream().map(a -> a.join()).collect(Collectors.toList()));
		LOGGER.info(result.get());
		ex.shutdown();
	}
}
