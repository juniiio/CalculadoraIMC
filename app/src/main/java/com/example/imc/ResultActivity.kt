package com.example.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)
        val result = intent.getFloatExtra("EXTRA_RESULT",0.1f)


        tvResult.text = result.toString()


        /* TABELA IMC
         MENOR QUE 18.5       ABAIXO DO PESO
         ENTRE 18.5 E 24.9    NORMAL
         ENTRE 25 E 29.9      SOBREPESO
         ENTRE 30 E 39.9      OBESIDADE
         MAIOR QUE 40.0       OBESIDADE GRAVE

         */

        var classificacao = ""

        if (result < 18.5f){
            classificacao = ": ABAIXO DO PESO"
        }else if (result >= 18.5f && result<=24.9f){
            classificacao = ": NORMAl"
        }else if (result >= 25f && result <= 29.9f){
            classificacao = ": SOBREPESO"
        }else if (result >= 30f && result<= 39.9f) {
            classificacao = ": OBESIDADE"
        }else if (result >= 40){
            classificacao = ": OBESIDADE GRAVE"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)





    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        finish()
        return super.onOptionsItemSelected(item)
    }
}
