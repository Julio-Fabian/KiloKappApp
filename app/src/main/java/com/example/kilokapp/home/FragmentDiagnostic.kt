package com.example.kilokapp.home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.kilokapp.R
import com.example.kilokapp.databinding.FragmentDiagnosticBinding
import com.example.kilokapp.databinding.FragmentExcercicesBinding
import com.example.sqlserverprototipe02.sql.SQLAcctions

class FragmentDiagnostic : Fragment() {

    private lateinit var preferences : SharedPreferences // mantiene la sesion iniciada.
    private lateinit var sesion : SQLAcctions
    private var _binding: FragmentDiagnosticBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDiagnosticBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view) // metodo mas recomndable.
        Init()

        binding.buttonSalir.setOnClickListener {
            this.requireActivity().finish()
        }

        binding.buttonCerrarSesion.setOnClickListener {
            preferences.edit().clear().apply() // limpia las preferences y cierra sesion
            this.requireActivity().finish()
        }
    }


    fun Init() {
        sesion = SQLAcctions()
        preferences = this.requireActivity().getSharedPreferences("Preferencias",
            Context.MODE_PRIVATE
        ) // creamos shared preferences
    }
}