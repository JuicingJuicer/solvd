package com.solvd.ta.lab2.interfaces;

import java.util.ArrayList;

import com.solvd.ta.lab2.items.Media;

@FunctionalInterface
public interface FormatterFunction<T extends Media> {
	void apply(ArrayList<Media> items);
}
