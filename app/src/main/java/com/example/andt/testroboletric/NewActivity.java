package com.example.andt.testroboletric;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NewActivity extends AppCompatActivity {

	TextView tvText;
	ListView listView;
	private ArrayList<String> sourcesArrayList = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new);
		tvText = (TextView) findViewById(R.id.tvText);
		listView = (ListView) findViewById(R.id.listview);
		sourcesArrayList.add("Samsung");
		sourcesArrayList.add("Android");
		sourcesArrayList.add("Google");
		sourcesArrayList.add("Asus");
		sourcesArrayList.add("Apple");
		sourcesArrayList.add("Samsung");
		sourcesArrayList.add("Android");
		sourcesArrayList.add("Google");
		sourcesArrayList.add("Asus");
		sourcesArrayList.add("Apple");
		sourcesArrayList.add("Samsung");
		sourcesArrayList.add("Android");
		sourcesArrayList.add("Google");
		sourcesArrayList.add("Asus");
		sourcesArrayList.add("Apple");

		ArrayAdapter<String> arrayAdapter
				= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1 , sourcesArrayList);
		listView.setAdapter(arrayAdapter);

		Intent intent = getIntent();
		if(intent.hasExtra("message")) {
			tvText.setText(intent.getStringExtra("message"));
		} else {
			tvText.setText("not found message extra");
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		tvText.setText("onDestroy");
	}
}
