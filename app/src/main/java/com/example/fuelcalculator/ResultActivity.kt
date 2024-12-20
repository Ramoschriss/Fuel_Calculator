package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


const val key_fuel_result = "KEY RESULT"


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val resultotal = findViewById<TextView>(R.id.tv_result)
        val resultprice = findViewById<TextView>(R.id.tv_preco)
        val resultconsume = findViewById<TextView>(R.id.tv_consumo)
        val resultkm = findViewById<TextView>(R.id.tv_km)
        val btncalculo = findViewById<Button>(R.id.btn_calculo)


        val price = intent.getFloatExtra("KEY PRICE", 0f)
        val consumo = intent.getFloatExtra("CONSUMER_FUEL", 0f)
        val distance = intent.getFloatExtra("KEY DISTANCE", 0f)



        resultprice.text = price.toString()
        resultconsume.text = consumo.toString()
        resultkm.text = distance.toString()

        val calculototal = if (consumo != 0f) {

            (distance / consumo) * price


        } else {
            0f

        }
        resultotal.text = "€ %.2f".format(calculototal)




        btncalculo.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


    }


}