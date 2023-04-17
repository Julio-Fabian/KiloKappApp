package com.example.kilokapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.kilokapp.databinding.ActivityMainBinding
import com.example.kilokapp.databinding.FragmentIniciarSesionBinding


class FragmentIniciarSesion : Fragment() {

    private var _binding: FragmentIniciarSesionBinding? = null
    private val binding get() = _binding!!

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
        IniciarUI()
    }

    private fun IniciarUI() {

        binding.botonIniciarSesion.setOnClickListener {

        }

        binding.textViewRecuperarPassword.setOnClickListener {

        }

        binding.textViewNuevaCuenta.setOnClickListener {

        }
    }
}