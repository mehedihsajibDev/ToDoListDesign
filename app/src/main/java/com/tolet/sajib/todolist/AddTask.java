package com.tolet.sajib.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class AddTask extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener
        ,AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        ImageView button = (ImageView) findViewById(R.id.button);
        Spinner coloredspinner=findViewById(R.id.coloredspinner);
        ArrayAdapter adapter=ArrayAdapter.createFromResource(this,
                R.array.countries
                ,R.layout.color_spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);

        coloredspinner.setAdapter(adapter);
        coloredspinner.setOnItemSelectedListener(this);

//        Spinner spinner = findViewById(R.id.spinner1);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.numbers, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        ImageView buttontime = (ImageView) findViewById(R.id.buttontime);
        buttontime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });



    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, i);
        c.set(Calendar.MONTH, i2);
        c.set(Calendar.DAY_OF_MONTH, i1);
        String currentDateString = DateFormat.getDateInstance(DateFormat.MEDIUM).format(c.getTime());
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(currentDateString);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        TextView textViewtime = (TextView) findViewById(R.id.textViewtime);
        textViewtime.setText(" " + i + ":" + i1);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        String text = adapterView.getItemAtPosition(i).toString();
       // Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
