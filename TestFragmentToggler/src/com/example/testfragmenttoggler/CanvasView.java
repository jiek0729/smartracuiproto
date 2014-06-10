package com.example.testfragmenttoggler;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

public class CanvasView extends View {
	private List<ListItem> listItems;

	public CanvasView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		setMinimumWidth(100);
		setMinimumHeight(200);
	}

	public void setListItems(List<ListItem> listItems) {
		this.listItems = listItems;
		this.invalidate();
	}

	public void setListItem(ListItem listItem) {
		if (listItems == null) {
			this.listItems = new ArrayList<ListItem>();
		}

		this.listItems.clear();
		this.listItems.add(listItem);
		this.invalidate();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.BLACK);

		if (listItems != null) {
			for (ListItem item : listItems) {
				item.getDrawable().draw(canvas);
			}
		}
	}
}
