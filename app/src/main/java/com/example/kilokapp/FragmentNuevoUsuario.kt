package com.example.kilokapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.kilokapp.databinding.FragmentIniciarSesionBinding
import com.example.kilokapp.databinding.FragmentNuevoUsuarioBinding
import com.example.kilokapp.databinding.FragmentTipoUsuarioBinding
import com.example.sqlserverprototipe02.sql.SQLAcctions

class FragmentNuevoUsuario : Fragment() {

    private lateinit var navController: NavController
    private var _binding: FragmentNuevoUsuarioBinding? = null
    private val binding get() = _binding!!

    var esNutriologo : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNuevoUsuarioBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view) // metodo mas recomndable.
        IniciarUI()

        binding.botonCrearCuenta.setOnClickListener {
            var user : String = binding.editTextUsuario.text.toString()
            var pass : String = binding.editTextPassword.text.toString()
            var pass2 : String = binding.editTextConfirmarPassword.text.toString()

            var esValido = validarCampos(user, pass, pass2)

            if (esValido) {
                val sesion = SQLAcctions()
                val respuesta : Boolean = sesion.crearUsuario(user, pass, esNutriologo)

                if (respuesta) {
                    Toast.makeText(context, "Usuario creado correctamente.", Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(context, "Error al crear usuario.", Toast.LENGTH_SHORT).show()
                }
            }
            else {
                Toast.makeText(context, "ERROR: Las contraseñas no son iguales.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun validarCampos(usuario: String, p1: String, p2: String) : Boolean {

        if (!p1.equals(p2))
            return false

        return true
    }

    private fun IniciarUI() {
        esNutriologo = FragmentNuevoUsuarioArgs.fromBundle(requireArguments()).esNutriologo
    }
}