package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class DistanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distance)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val edtdistance = findViewById<TextInputEditText>(R.id.edtdistance)
        val btncalcular = findViewById<Button>(R.id.btncalcular)

        btncalcular.setOnClickListener {



            val distanceStr: String = edtdistance.text.toString()


            if (distanceStr == "") {
                Snackbar.make(
                    edtdistance, "Preencha o campo vazio",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {

                val distance = distanceStr.toFloat()


                val pricefuel = intent.getFloatExtra("111", 0f)
                val consumer = intent.getFloatExtra("222", 0f)


                val litrosNecessary = distance / consumer
                val gastoTotal = litrosNecessary * pricefuel

                println(gastoTotal)


                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("444", gastoTotal)
                startActivity(intent)


            }
        }


    }

}