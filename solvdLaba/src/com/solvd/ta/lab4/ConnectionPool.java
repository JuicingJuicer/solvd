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

	public Connection getConnection() {
		Connection c = pool.remove(pool.size() - 1);
		usedPool.add(c);
		return c;
	}

	public void releaseConnection(Connection c) {
		pool.add(c);
		usedPool.remove(c);
	}
}
