package com.adapter;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class AdapterActivity extends ActionBarActivity {

	private List<CharSequence> getcities(){
		
		List<CharSequence> cities=new ArrayList<CharSequence>();
		cities.add("Ýzmir");
		cities.add("Erzurum");
		cities.add("Ankara");
		cities.add("Mersin");
		cities.add("Ýstanbul");
		return cities;
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adapter);
	final List<CharSequence> cities=getcities();
	
	final ArrayAdapter<CharSequence> adapter=new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_dropdown_item,cities);
	Spinner spinner=(Spinner) findViewById(R.id.spinner);
	spinner.setAdapter(adapter);
	
	Button kaydetbutton=(Button) findViewById(R.id.kaydetButton);
	final EditText sehirEditText=(EditText) findViewById(R.id.sehirEditText);
	final TextView durumTextView=(TextView) findViewById(R.id.durumTextView);
	
	kaydetbutton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			String sehiradi=sehirEditText.getText().toString();
		    cities.add(sehiradi);
		    adapter.notifyDataSetChanged();
		    sehirEditText.setText("");
		    durumTextView.setText(sehiradi+""+"eklendi");
			
		}
	});
	}
}
