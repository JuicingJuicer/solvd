package com.solvd.ta.lab2;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.ta.lab2.exceptions.CartIsEmptyException;
import com.solvd.ta.lab2.interfaces.ShoppingCart;
import com.solvd.ta.lab2.items.Media;

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

	public ArrayList<Media> checkout() {
		logger.info("Checking out ...");
		ArrayList<Media> temp = new ArrayList<Media>();
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
