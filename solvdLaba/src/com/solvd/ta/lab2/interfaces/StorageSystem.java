package com.solvd.ta.lab2.interfaces;

import com.solvd.ta.lab2.Preferences;
import com.solvd.ta.lab2.items.Media;

public interface StorageSystem {
	public void addMedia(Media media);

	public void removeMedia(Media media);

	public void filterItems(Preferences preferences);
}
