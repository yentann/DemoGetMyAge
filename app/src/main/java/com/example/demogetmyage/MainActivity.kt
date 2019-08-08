package com.example.demogetmyage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGetAge.setOnClickListener {
            val userDOB = editDOB.text.toString()
            if(userDOB.isNotEmpty()) {
                val year = Calendar.getInstance().get(Calendar.YEAR)
                val age = year - userDOB.toInt()

                var output = ""

                when (age) {
                    in 0..17 -> output = "Underage"
                    in 18..65 -> output = "Young people"
                    in 66..79 -> output = "Middle-aged"
                    in 80..99 -> output = "Elderly"
                    else -> {
                        output = "Long-lived elderly"
                    }
                }
                tvShowAge.text = "Your age is $age and you are $output"
            } else {
                Toast.makeText(this, "Please enter your birth", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
