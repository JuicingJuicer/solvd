package com.solvd.ta.lab2.collections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.ta.lab2.items.Media;

public class LinkedList<T extends Media> {
	Node<T> head;
	private int len = 0;
	private static Logger LOGGER = LogManager.getLogger(LinkedList.class.getName());

	public LinkedList() {
		this.head = null;
	}

	public void add(T data) {
		Node<T> temp = new Node<>(data);

		// empty
		if (this.head == null) {
			head = temp;
		}
		// not empty
		else {
			Node<T> cur = head;
			while (cur.next != null) {
				cur = cur.next;
			}
			cur.next = temp;
		}
		len++;
	}

	public void add(int pos, T data) {
		if (pos > len + 1) {
			LOGGER.error("Invalid Position!");
			return;
		}
		// start position
		if (pos == 1) {
			Node<T> temp = head;
			head = new Node<T>(data);
			head.next = temp;
			return;
		}

		Node<T> cur = head;
		Node<T> prev = new Node<T>(null);

		// loop to position
		while (pos - 1 > 0) {
			// shift the two nodes forward
			prev = cur;
			cur = cur.next;
			pos--;
		}
		prev.next = new Node<T>(data);
		prev.next.next = cur;
	}

	public void remove(T data) {
		boolean real = false;
		Node<T> prev = new Node<>(null);
		prev.next = head;
		Node<T> next = head.next;
		Node<T> cur = head;

		// if value is the head
		if (head.data == data) {
			head = head.next;
			real = true;
		}

		while (cur.next != null) {
			if (String.valueOf(cur.data).equals(String.valueOf(data))) {
				prev.next = next;
				real = true;
				break;
			}
			// shift the three nodes forward
			prev = cur;
			cur = cur.next;
			next = cur.next;
		}

		// if the desired node is at the end
		if (real == false && String.valueOf(cur.data).equals(String.valueOf(data))) {
			prev.next = null;
			real = true;
		}

		if (real) {
			len--;
		} else {
			LOGGER.error("Invalid value");
		}
	}

	public void clear() {
		head = null;
		len = 0;
	}

	@Override
	public String toString() {
		Node<T> cur = head;
		String string = "[";

		// empty
		if (cur == null)
			return string + "]";

		while (cur.next != null) {
			string += String.valueOf(cur.data.getTitle()) + ", ";
			cur = cur.next;
		}
		string += String.valueOf(cur.data.getTitle()) + "]";
		return string;
	}
}
