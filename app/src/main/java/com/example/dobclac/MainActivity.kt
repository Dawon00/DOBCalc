package com.example.dobclac

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private var tvSelectedDate : TextView? = null
    private var tvAgeInMinutes : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker : Button = findViewById(R.id.btnDatePicker)

        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        tvAgeInMinutes =  findViewById(R.id.tvAgeInMinutes)
        btnDatePicker.setOnClickListener{ view ->


            clickDatePicker()
        }
    }
    private fun clickDatePicker(){

        val mayCalendar = Calendar.getInstance()
        val year = mayCalendar.get(Calendar.YEAR)
        val month = mayCalendar.get(Calendar.MONTH)
        val day = mayCalendar.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this,
            { view, selectedYear, selectedMonth, selectedDayOfMonth ->
                Toast.makeText(this,
                    "Year was $selectedYear, month was ${selectedMonth+1}, day of month was $selectedDayOfMonth",
                    Toast.LENGTH_LONG).show()
                val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/${selectedYear}"
                tvSelectedDate?.setText(selectedDate)
                var sdf = SimpleDateFormat("dd/MM/yyyy", Locale.KOREAN)
                val theDate = sdf.parse(selectedDate)
                val selectedDateInMunites = theDate.time / 60000
                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                val currentDateInMunites = currentDate.time / 60000
                val differeceInMinutes = currentDateInMunites - selectedDateInMunites






            },
            year,
            month,
            day
        )
        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400
        dpd.show()

    }
}