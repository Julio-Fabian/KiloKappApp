package com.example.kilokapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kilokapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // inicializamos cada uno de los botones.
        IniciarUI()
    }

    private fun IniciarUI() {

        binding.botonIniciarSesion.setOnClickListener {
            val toast = Toast.makeText(applicationContext, "Iniciando sesion", Toast.LENGTH_SHORT)
            toast.show()
        }

        binding.textViewRecuperarPassword.setOnClickListener {
            val toast = Toast.makeText(applicationContext, "Pulsaste Recuperar contrasena", Toast.LENGTH_SHORT)
            toast.show()
        }

        binding.textViewNuevaCuenta.setOnClickListener {
            val toast = Toast.makeText(applicationContext, "Pulsaste Crear nueva cuenta", Toast.LENGTH_SHORT)
            toast.show()

            var intent = Intent(this, NewUserActivity::class.java);
            startActivity(intent);
        }
    }
}