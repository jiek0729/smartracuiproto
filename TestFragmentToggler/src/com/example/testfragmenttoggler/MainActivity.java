package com.example.testfragmenttoggler;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnItemClickListener {
	private Fragment calendar = new FragmentMain();
	private Fragment canvas = new FragmentSecond();
	private Fragment canvasSingle = new FragmentSecondSingle();
	private Fragment editLine = new FragmentEditLine();

	public ListItemsGenerator model;

	private ListItem selectedListItem;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		model = new ListItemsGenerator(this);
		model.generateListItems();

		if (savedInstanceState == null) {
			FragmentTransaction ft = getFragmentManager().beginTransaction();

			ft.setCustomAnimations(R.animator.slide_in_up,
					R.animator.slide_out_up);

			ft.add(R.id.container, calendar).commit();
		}

		Button calendarButton = (Button) findViewById(R.id.button1);
		Button canvasButton = (Button) findViewById(R.id.button2);
		calendarButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				FragmentTransaction ft = getFragmentManager()
						.beginTransaction();

				ft.setCustomAnimations(R.animator.slide_in_right,
						R.animator.slide_out_left);

				ft.remove(editLine);

				ft.replace(R.id.container, calendar).commit();
			}

		});

		canvasButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentTransaction ft = getFragmentManager()
						.beginTransaction();

				ft.setCustomAnimations(R.animator.slide_in_up,
						R.animator.slide_out_up);

				ft.remove(editLine);

				ft.replace(R.id.container, canvas).commit();
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		this.selectedListItem = (ListItem) arg0.getItemAtPosition(arg2);

		FragmentTransaction ft = getFragmentManager().beginTransaction();

		ft.setCustomAnimations(R.animator.slide_in_up, R.animator.slide_out_up);

		ft.replace(R.id.container, canvasSingle);

		ft.add(R.id.container, editLine);

		ft.commit();
	}

	public ListItem getSelectedListItem() {
		return this.selectedListItem;
	}
}
