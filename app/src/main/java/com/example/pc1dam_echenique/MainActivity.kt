package com.example.pc1dam_echenique

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val etParcial: EditText = findViewById(R.id.etParcial)
        val etFinal: EditText = findViewById(R.id.etFinal)
        val etPEP: EditText = findViewById(R.id.etPEP)
        val btnSend: Button = findViewById(R.id.btnCalcular)
        btnSend.setOnClickListener{
            this.promedio(etParcial.text.toString(),etFinal.text.toString(),etPEP.text.toString())
        }

    }
    private fun promedio(Parcial: String,Final: String,PEP: String){
        val dParcial = Parcial.toDouble()
        val dFinal = Final.toDouble()
        val dPep = PEP.toDouble()
        val resultado: Double
        resultado = dParcial*0.20 + dFinal * 0.20 + dPep*0.6
        val intent = Intent(this,Resultado::class.java)
        intent.putExtra("param",resultado)
        startActivity(intent)
    }

}