package com.example.testfragmenttoggler;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

public class ListItemsGenerator {
	public interface OnGeneratedListener {
		void onGenerated(List<ListItem> listItems);
	}

	private Bitmap bitmap;

	private Context context;

	private List<ListItem> listItems;

	private List<OnGeneratedListener> listeners = new ArrayList<OnGeneratedListener>();

	public ListItemsGenerator(Context context) {
		this.context = context;
		getBitmap();
	}

	private void getBitmap() {
		Bitmap bitmapOriginal = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.pyconic);
		Matrix matrix = new Matrix();
		matrix.postScale(0.5f, 0.5f);
		bitmap = Bitmap.createBitmap(bitmapOriginal, 0, 15, 50, 50);
	}

	public void registerListener(OnGeneratedListener listener) {
		if (listItems != null) {
			listener.onGenerated(listItems);
		}

		listeners.add(listener);
	}

	public void unregisterListener(OnGeneratedListener listener) {
		listeners.remove(listener);
	}

	public void generateListItems() {
		listItems = new ArrayList<ListItem>();

		for (int i = 200; i < 1500; i += 200) {
			final int height = i;
			ListItem item = new ListItem("Horizontal Line " + height,
					"Draw a horizontal line in canvas at " + height,
					new Drawable() {

						@Override
						public void draw(Canvas canvas) {
							// TODO Auto-generated method stub
							Paint paint = new Paint();
							paint.setColor(Color.WHITE);
							paint.setStrokeWidth(20);
							canvas.drawLine(0, height, canvas.getWidth(),
									height, paint);
						}

						@Override
						public int getOpacity() {
							// TODO Auto-generated method stub
							return 0;
						}

						@Override
						public void setAlpha(int arg0) {
							// TODO Auto-generated method stub

						}

						@Override
						public void setColorFilter(ColorFilter arg0) {
							// TODO Auto-generated method stub

						}

					});

			item.setIcon(bitmap);

			ListItem item2 = new ListItem("Circle " + height,
					"Draw a circle at " + height, new Drawable() {

						@Override
						public void draw(Canvas canvas) {
							// TODO Auto-generated method stub
							Paint paint = new Paint();
							paint.setColor(Color.RED);
							paint.setStrokeWidth(5);
							canvas.drawCircle(canvas.getWidth() / 2, height,
									50, paint);
						}

						@Override
						public int getOpacity() {
							// TODO Auto-generated method stub
							return 0;
						}

						@Override
						public void setAlpha(int arg0) {
							// TODO Auto-generated method stub

						}

						@Override
						public void setColorFilter(ColorFilter arg0) {
							// TODO Auto-generated method stub

						}

					});

			listItems.add(item);
			listItems.add(item2);
		}

		notifyListeners();
	}

	private void notifyListeners() {
		for (OnGeneratedListener listener : listeners) {
			listener.onGenerated(listItems);
		}
	}
}
