package com.solvd.ta.lab4;

import java.util.concurrent.CopyOnWriteArrayList;

public class ConnectionPool {
	private CopyOnWriteArrayList<Connection> pool = new CopyOnWriteArrayList<>();
	private CopyOnWriteArrayList<Connection> usedPool = new CopyOnWriteArrayList<>();

	ConnectionPool(int size) {
		for (int i = 0; i < size; i++) {
			pool.add(new Connection());
		}
	}

	public synchronized Connection getConnection() {
		if (pool.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Connection c = pool.remove(0);
		usedPool.add(c);
		return c;
	}

	public synchronized void releaseConnection(Connection c) {
		usedPool.remove(c);
		pool.add(c);
		notify();
	}
}
