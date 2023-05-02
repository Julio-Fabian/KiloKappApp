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
import com.example.kilokapp.databinding.FragmentTipoUsuarioBinding


class FragmentTipoUsuario : Fragment() {

    private lateinit var navController: NavController
    private var _binding: FragmentTipoUsuarioBinding? = null
    private val binding get() = _binding!!

    private var esNutriologo : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTipoUsuarioBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view) // metodo mas recomndable.
        IniciarUI()
    }


    private fun IniciarUI() {
        binding.btnNutriologo.setOnClickListener {
            esNutriologo = true // activamos check.

            val action = FragmentTipoUsuarioDirections.nextAction(esNutriologo)
            navController.navigate(action)
        }

        binding.btnPaciente.setOnClickListener {

            val action = FragmentTipoUsuarioDirections.nextAction(esNutriologo)
            navController.navigate(action)
        }
    }
}