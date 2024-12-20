package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

const val key_fuel_price = "KEY PRICE"

class Price_fuelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_price_fuel)


        val edtcombustivel = findViewById<TextInputEditText>(R.id.edt_combustivel)
        val btnproximo1 = findViewById<Button>(R.id.btn_proximo1)

        btnproximo1.setOnClickListener {
            val combustivelStr: String = edtcombustivel.text.toString()

            if (combustivelStr == "") {

                Snackbar.make(
                    edtcombustivel, "Preencha o campo vazio ",
                    Snackbar.LENGTH_LONG
                )
                    .show()


            } else {

                val pricefuel = edtcombustivel.text.toString().toFloatOrNull() ?: 0.0


                val intent = Intent(this, Consumer_FuelActivity::class.java)
                intent.putExtra(key_fuel_price, pricefuel)
                startActivity(intent)
            }
        }


    }


}

