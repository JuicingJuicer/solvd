package com.solvd.ta.lab2;

import java.util.ArrayList;
import java.util.function.Predicate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.ta.lab2.exceptions.CartIsEmptyException;
import com.solvd.ta.lab2.interfaces.ShoppingCart;
import com.solvd.ta.lab2.items.Media;

public class Cart extends Storage implements ShoppingCart {
	private static final Logger LOGGER = LogManager.getLogger(Cart.class.getName());
	Predicate<Integer> greaterThanZero = x -> x > 0;

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
		LOGGER.info("Checking out ...");
		ArrayList<Media> temp = new ArrayList<Media>();
		for (Media m : filteredArr) {
			temp.add(m);
		}
		filteredArr.clear();
		return temp;
	}

	public void printCart() {
		LOGGER.info("Cart: ");
		LOGGER.info(getCartSize() + " item(s)");
		this.printInventory();
	}

	public int getCartSize() {
		return filteredArr.size();
	}

	public boolean checkNotEmpty() throws CartIsEmptyException {
		if (greaterThanZero.test(getCartSize())) {
			return true;
		}
		throw new CartIsEmptyException("You cannot check out with an empty cart! Go add something!");
	}

}
