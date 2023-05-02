package com.solvd.ta.lab2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.ta.lab2.Exceptions.CartIsEmptyException;

interface ShoppingCart {
	public void addToCart(Media media);

	public void removeFromCart(Media media);

	public LinkedList<Media> checkout();

	public void printCart();

	public int getCartSize();
}

public class Cart extends Storage implements ShoppingCart {
	private static final Logger logger = LogManager.getLogger(Cart.class.getName());

	public Cart(int capacity) {
		super(capacity);
	}

	public Cart() {
		super();
	}

	public void addToCart(Media media) {
		filteredArr.add(media);
	}

	public void removeFromCart(Media media) {
		filteredArr.remove(media);
	}

	public LinkedList<Media> checkout() {
		logger.info("Checking out ...");
		LinkedList<Media> temp = new LinkedList<>();
		for (Media m : filteredArr) {
			temp.add(m);
		}
		filteredArr.clear();
		return temp;
	}

	public void printCart() {
		logger.info("Cart: ");
		logger.info(getCartSize() + " item(s)");
		this.printInventory();
	}

	public int getCartSize() {
		return filteredArr.size();
	}

	public boolean checkNotEmpty() throws CartIsEmptyException {
		if (getCartSize() > 0) {
			return true;
		}
		throw new CartIsEmptyException("You cannot check out with an empty cart! Go add something!");
	}

}
