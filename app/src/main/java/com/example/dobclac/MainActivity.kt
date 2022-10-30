package com.example.dobclac

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker : Button = findViewById(R.id.btnDatePicker)

        btnDatePicker.setOnClickListener{ view ->


            clickDatePicker()
        }
    }
    fun clickDatePicker(){

        val mayCalendar = Calendar.getInstance()
        val year = mayCalendar.get(Calendar.YEAR)
        val month = mayCalendar.get(Calendar.MONTH)
        val day = mayCalendar.get(Calendar.DAY_OF_MONTH)


        DatePickerDialog(this,
            { view, year, month, dayOfMonth ->
            Toast.makeText(this, "btnDatePicker works", Toast.LENGTH_LONG).show()
        },
            year,
            month,
            day
             ).show()

    }
}