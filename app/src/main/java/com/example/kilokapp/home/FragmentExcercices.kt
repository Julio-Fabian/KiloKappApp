package com.example.kilokapp.home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kilokapp.R
import com.example.kilokapp.databinding.FragmentExcercicesBinding
import com.example.kilokapp.databinding.FragmentIniciarSesionBinding
import com.example.sqlserverprototipe02.sql.SQLAcctions

class FragmentExcercices : Fragment() {

    private lateinit var preferences : SharedPreferences // mantiene la sesion iniciada.
    private lateinit var sesion : SQLAcctions
    private var _binding: FragmentExcercicesBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentExcercicesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // code here...
        Init()

        val user : String? = preferences.getString("USER", null)
        val id : Int = preferences.getInt("USER_ID", 0)

        if (user != null && id > 0) {
            val msg = "¡Hola ${user}! ¡bienvenido!"
            binding.textViewEjericios.text =  msg
        }


    }

    fun Init() {
        sesion = SQLAcctions()
        preferences = this.requireActivity().getSharedPreferences("Preferencias",
            Context.MODE_PRIVATE
        ) // creamos shared preferences
    }

}