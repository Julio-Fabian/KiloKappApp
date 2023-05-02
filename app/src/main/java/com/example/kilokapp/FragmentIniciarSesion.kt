package com.example.kilokapp

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.kilokapp.databinding.FragmentIniciarSesionBinding
import com.example.sqlserverprototipe02.sql.SQLAcctions
import java.sql.ResultSet


class FragmentIniciarSesion : Fragment() {

    private lateinit var navController: NavController
    private var _binding: FragmentIniciarSesionBinding? = null
    private val binding get() = _binding!!

    private lateinit var sesion : SQLAcctions
    private lateinit var preferences : SharedPreferences // mantiene la sesion iniciada.

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentIniciarSesionBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // aqui se llama al codigo de la app.
        navController = Navigation.findNavController(view) // metodo mas recomndable.

        Init() // inicializamos variables globales

        IniciarUI()
    }

    fun Init() {
        sesion = SQLAcctions()
        preferences = this.requireActivity().getSharedPreferences("Preferencias", MODE_PRIVATE) // creamos shared preferences
    }

    fun verificarSesionIniciada() { // si existe una sesion activa, omitimos el login.
        // code here ...
        val user : String? = preferences.getString("USER", null)
        val id : Int = preferences.getInt("USER_ID", 0)

        if (user != null && id > 0) {
            navController.navigate(R.id.action_go_home)
        }
    }


    private fun IniciarUI() {

        binding.botonIniciarSesion.setOnClickListener {

            var user : String = binding.editTextUsuario.text.toString()
            var pass : String = binding.editTextPassword.text.toString()

            var resultado : ResultSet? = sesion.buscarUsuarioIniciarSesion(user, pass)

            if (resultado != null) {
                val editor = preferences.edit()
                editor.putInt("USER_ID", resultado.getString(1).toInt())
                editor.putString("USER", resultado.getString(2).toString())
                editor.apply()


                Toast.makeText(context, "!Bienvenido ${user}¡ Iniciando Sesion...", Toast.LENGTH_SHORT).show()
                navController.navigate(R.id.action_go_home) // TODO reemplazar por activity (asi funciona mejor el cerrar sesion)
            }
            else {
                Toast.makeText(context, "La cuenta ingresada no existe", Toast.LENGTH_SHORT).show()
            }
        }

        binding.textViewRecuperarPassword.setOnClickListener {

        }

        binding.textViewNuevaCuenta.setOnClickListener {
            navController.navigate(R.id.action_nuevo_usuario)
        }
    }
}