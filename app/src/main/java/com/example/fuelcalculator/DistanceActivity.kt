package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

const val key_fuel_distance = "KEY DISTANCE"


class DistanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distance)

        val price = intent.getFloatExtra("KEY PRICE", 0f)
        val consumo = intent.getFloatExtra("CONSUMER_FUEL", 0f)

        val edtdistance = findViewById<TextInputEditText>(R.id.edt_distance)
        val btncalcular = findViewById<Button>(R.id.btn_calcular)

        btncalcular.setOnClickListener {


            if (edtdistance.text.toString() == "") {
                Snackbar.make(
                    edtdistance, "Preencha o campo vazio",
                    Snackbar.LENGTH_LONG
                ).show()

            } else {

                val distance = edtdistance.text.toString().toFloatOrNull() ?: 0.0


                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(key_fuel_distance, distance)
                intent.putExtra("KEY PRICE", price)
                intent.putExtra("CONSUMER_FUEL", consumo)
                startActivity(intent)


            }
        }


    }

}