package com.example.testfragmenttoggler;

import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.testfragmenttoggler.ListItemsGenerator.OnGeneratedListener;

public class FragmentMain extends Fragment {

	private static final String TAG = "FragmentMain";

	private ListItemsGenerator model;

	private OnGeneratedListener listener;

	@Override
	public void onAttach(Activity activity) {
		Log.i(TAG, getClass().getSimpleName() + ":entered onAttach()");
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, getClass().getSimpleName() + ":entered onCreate()");
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		MainActivity act = (MainActivity) getActivity();
		model = act.model;

		listener = new OnGeneratedListener() {

			@Override
			public void onGenerated(List<ListItem> listItems) {
				// TODO Auto-generated method stub
				ListView lv = (ListView) getView().findViewById(R.id.listItems);
				ListItemArrayAdapter adapter = new ListItemArrayAdapter(
						FragmentMain.this.getActivity(), listItems);
				lv.setAdapter(adapter);
			}
		};
		return inflater.inflate(R.layout.fragment_main, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onStart() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onStart()");
		model.registerListener(listener);
		MainActivity act = (MainActivity) getActivity();
		ListView lv = (ListView) getView().findViewById(R.id.listItems);
		lv.setOnItemClickListener(act);
		super.onStart();
	}

	@Override
	public void onResume() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onResume()");
		super.onResume();
	}

	@Override
	public void onPause() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onPause()");
		super.onPause();
	}

	@Override
	public void onStop() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onStop()");
		this.model.unregisterListener(listener);
		super.onStop();
	}

	@Override
	public void onDetach() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onDetach()");
		super.onDetach();
	}

	@Override
	public void onDestroy() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onDestroy()");
		super.onDestroy();
	}

	@Override
	public void onDestroyView() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onDestroyView()");
		super.onDestroyView();
	}

	public class ListItemArrayAdapter extends ArrayAdapter<ListItem> {
		private final Context context;
		private final List<ListItem> values;

		public ListItemArrayAdapter(Context context, List<ListItem> values) {
			super(context, R.layout.item, values);
			this.context = context;
			this.values = values;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View rowView = inflater.inflate(R.layout.item, parent, false);
			TextView nameView = (TextView) rowView.findViewById(R.id.name);
			TextView descriptionView = (TextView) rowView
					.findViewById(R.id.description);
			ImageView imageView = (ImageView) rowView
					.findViewById(R.id.imageView1);
			nameView.setText(values.get(position).getName());
			descriptionView.setText(values.get(position).getDescription());
			if (values.get(position).getIcon() != null) {
				imageView.setImageBitmap(values.get(position).getIcon());
			}

			return rowView;
		}
	}
}
