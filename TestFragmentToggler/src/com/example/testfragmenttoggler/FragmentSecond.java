package com.example.testfragmenttoggler;

import java.util.List;

import com.example.testfragmenttoggler.ListItemsGenerator.OnGeneratedListener;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentSecond extends Fragment {

	private static final String TAG = "FragmentSecond";
	
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
		listener = new OnGeneratedListener() {
			
			@Override
			public void onGenerated(List<ListItem> listItems) {
				// TODO Auto-generated method stub
				CanvasView cv = (CanvasView)getView().findViewById(R.id.canvasView1);
				cv.setListItems(listItems);
			}
		};
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		MainActivity act = (MainActivity)getActivity();
		this.model = act.model;
		return inflater.inflate(R.layout.fragment_second, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
	
	@Override
	public void onStart() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onStart()");
		model.registerListener(listener);
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
		super.onStop();
	}
	
	@Override
	public void onDetach() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onDetach()");
		this.model.unregisterListener(listener);
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

}
