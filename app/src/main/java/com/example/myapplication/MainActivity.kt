package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

const val GET_SHARED_PREFS = "getNumber"
const val NUMBER_SAVED = "getNumber"


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val saveButton = findViewById<Button>(R.id.save)



        loadShared()


        saveButton.setOnClickListener(){
            saveShared()
        }
    }


    private fun saveShared(){
        val editTextNumber  = findViewById<EditText>(R.id.ed_text_number)
        val textViewNumber  = findViewById<TextView>(R.id.number)

        val inputNumber : String = editTextNumber.text.toString()
        textViewNumber.text = inputNumber
        val sharedPrefs = getSharedPreferences(GET_SHARED_PREFS, Context.MODE_PRIVATE)

        sharedPrefs
            .edit()
            ?.putString(NUMBER_SAVED, inputNumber)
            ?.apply()

        Toast.makeText(this, "Il numero è stato salvato", Toast.LENGTH_SHORT).show()
    }

    private fun loadShared(){
        val textViewNumber  = findViewById<TextView>(R.id.number)
        val sharedPreferences = getSharedPreferences(GET_SHARED_PREFS, Context.MODE_PRIVATE)
        val savedNumber = sharedPreferences.getString(NUMBER_SAVED, null)
        textViewNumber.text = savedNumber
    }


}