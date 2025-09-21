package com.yantrigo.printtable;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	private EditText etNumber;
	private Button btnPrint;
	private TextView tvResult;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		etNumber = findViewById(R.id.etNumber);
		btnPrint = findViewById(R.id.btnPrint);
		tvResult = findViewById(R.id.tvResult);
		
		btnPrint.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				String input = etNumber.getText().toString().trim();
				if(input.isEmpty()){
					Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_SHORT).show();
					return;
				}
				int number;
				try{
					number = Integer.parseInt(input);
				}catch(NumberFormatException e){
					Toast.makeText(MainActivity.this, "Invalid number", Toast.LENGTH_SHORT).show();
					return;
				}
				StringBuilder table = new StringBuilder();
				for(int i=1; i<=10; i++){
					table.append(number).append(" x ").append(i).append(" = ").append(number * i).append("\n");
				}
				tvResult.setText(table.toString());
			}
		});
	}

}
