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

class FragmentNuevoUsuario : Fragment() {

    private lateinit var navController: NavController
    private var _binding: FragmentNuevoUsuarioBinding? = null
    private val binding get() = _binding!!

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
    }

    private fun IniciarUI() {
        binding.botonCrearCuenta.setOnClickListener {
            val toast = Toast.makeText(context, "Creando cuenta...", Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}