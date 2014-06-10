package com.example.testfragmenttoggler;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class ListItem {
	private String name;
	private String description;
	private Drawable drawable;
	private Bitmap icon;

	public ListItem(String name, String description, Drawable drawable) {
		this.name = name;
		this.description = description;
		this.drawable = drawable;
	}

	public void setIcon(Bitmap icon) {
		this.icon = icon;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Drawable getDrawable() {
		return this.drawable;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public Bitmap getIcon() {
		return this.icon;
	}
}
