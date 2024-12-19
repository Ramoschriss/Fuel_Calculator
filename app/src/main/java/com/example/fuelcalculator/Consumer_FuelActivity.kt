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

class Consumer_FuelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consumer_fuel)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val edtconsumer = findViewById<TextInputEditText>(R.id.edtconsumer)
        val btnproximo2 = findViewById<Button>(R.id.btnproximo2)

        btnproximo2.setOnClickListener {


            val consumerStr: String = edtconsumer.text.toString()

            if (consumerStr == "") {
                Snackbar.make(
                    edtconsumer, "Preencha o campo vazio",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {

                val consumer = consumerStr.toFloat()


                val intent = Intent(this, DistanceActivity::class.java)
                intent.putExtra("222", consumer)
                startActivity(intent)
            }
        }


    }
}