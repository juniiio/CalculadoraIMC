package com.example.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val edtPeso: EditText = findViewById(R.id.editPeso)
        val edtAltura: EditText = findViewById(R.id.editAltura)


        btnCalcular.setOnClickListener {


            val alturaStr = edtAltura.text.toString()
            val pesoStr = edtPeso.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {


                val altura: Float = alturaStr.toFloat()
                val alturaFinal = altura * altura

                val peso: Float = pesoStr.toFloat()
                val result = peso / alturaFinal


                val intent = Intent(this, ResultActivity::class.java)

                    .apply {

                        putExtra("EXTRA_RESULT", result)
                    }


                startActivity(intent)
            } else {
                Toast.makeText(this, "PREENCHA TODOS OS CAMPOS", Toast.LENGTH_LONG).show()
            }


        }

    }
}
