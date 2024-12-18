package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class Price_fuelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_price_fuel)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtcombustivel = findViewById<TextInputEditText>(R.id.edt_combustivel)
        val btnproximo1 = findViewById<Button>(R.id.proximo1)

        btnproximo1.setOnClickListener {
            val combustivel = edtcombustivel.text
            val intent = Intent(this, Consumer_FuelActivity::class.java)
            startActivity(intent)
        }


    }


}

