package com.example.exercicio9;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView textViewDateTime;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewDateTime = findViewById(R.id.textViewDateTime);
        Button buttonSetDate = findViewById(R.id.buttonSetDate);
        Button buttonSetTime = findViewById(R.id.buttonSetTime);

        calendar = Calendar.getInstance();
        updateDateTime();
        buttonSetDate.setOnClickListener(v -> showDatePickerDialog());
        buttonSetTime.setOnClickListener(v -> showTimePickerDialog());
    }

    private void updateDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
        textViewDateTime.setText(sdf.format(calendar.getTime()));
    }

    private void showDatePickerDialog() {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view, year1, monthOfYear, dayOfMonth) -> {
                    calendar.set(Calendar.YEAR, year1);
                    calendar.set(Calendar.MONTH, monthOfYear);
                    calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    updateDateTime();
                }, year, month, day);
        datePickerDialog.show();
    }

    private void showTimePickerDialog() {
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                (view, hourOfDay, minute1) -> {
                    calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                    calendar.set(Calendar.MINUTE, minute1);
                    updateDateTime();
                }, hour, minute, true);
        timePickerDialog.show();
    }
}
