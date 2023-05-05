package com.solvd.ta.lab2.interfaces;

import java.util.ArrayList;

import com.solvd.ta.lab2.items.Media;

public interface ShoppingCart {
	public void addToCart(Media media);

	public void removeFromCart(Media media);

	public ArrayList<Media> checkout();

	public void printCart();

	public int getCartSize();
}
