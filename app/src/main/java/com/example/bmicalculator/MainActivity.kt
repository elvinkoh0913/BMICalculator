package com.example.bmicalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
import android.view.inputmethod.InputMethodManager


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        calcBtn.setOnClickListener() {

            val msg: String = editHeight.text.toString()

            //check if the EditText have values or not
            if(msg.trim().length>0) {
                Toast.makeText(applicationContext, "Message : "+msg, Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext, "Please enter some message! ", Toast.LENGTH_SHORT).show()

            }
            var getHeight:Double = editHeight.text.toString().toDouble()
            var getWeight:Double = editWeight.text.toString().toDouble()
            var bmi:Double = getWeight / Math.pow(getHeight, 2.0)

            Toast.makeText(this@MainActivity, "Calculate...", Toast.LENGTH_SHORT).show()

            BMI.text = "BMI: " + String.format(" %.2f", bmi)

            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)

            if (bmi < 18.5) {
                imageBMI.setImageResource(R.drawable.under);
            }
            else if (bmi >= 18.5 && bmi < 24.9) {
                imageBMI.setImageResource(R.drawable.normal);
            }
            else
                imageBMI.setImageResource(R.drawable.over);
        }

        resetBtn.setOnClickListener()
        {
            editHeight.text = null;
            editWeight.text = null;
            BMI.text = null;
            imageBMI.setImageResource(R.drawable.empty);
        }

    }
}
