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

const val key_fuel_consumer = "CONSUMER_FUEL"

class Consumer_FuelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consumer_fuel)
        val price = intent.getFloatExtra("KEY PRICE", 0f)


        val edtconsumer = findViewById<TextInputEditText>(R.id.edt_consumer)
        val btnproximo2 = findViewById<Button>(R.id.btn_proximo2)

        btnproximo2.setOnClickListener {




            if (edtconsumer.text.toString() == "") {
                Snackbar.make(
                    edtconsumer, "Preencha o campo vazio",
                    Snackbar.LENGTH_LONG
                ).show()

            } else {

                val consumer = edtconsumer.text.toString().toFloatOrNull() ?: 0.0


                val intent = Intent(this, DistanceActivity::class.java)
                intent.putExtra(key_fuel_consumer, consumer)
                intent.putExtra("KEY PRICE",price)
                startActivity(intent)
            }
        }


    }
}