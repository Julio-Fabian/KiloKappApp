package com.example.kilokapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kilokapp.databinding.ActivityMainBinding
import com.example.kilokapp.databinding.ActivityNewUserBinding

class NewUserActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNewUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // inicializamos cada uno de los botones.
        IniciarUI()
    }

    private fun IniciarUI() {

        binding.buttonRegresar.setOnClickListener {
            val toast = Toast.makeText(applicationContext, "Regresando a Iniciando sesion", Toast.LENGTH_SHORT)
            toast.show()

            var intent = Intent(this, MainActivity::class.java);
            startActivity(intent);
        }

        binding.botonCrearCuenta.setOnClickListener {
            val toast = Toast.makeText(applicationContext, "Creando cuenta...", Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}