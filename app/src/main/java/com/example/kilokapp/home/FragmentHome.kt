package com.example.kilokapp.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.kilokapp.R
import com.example.kilokapp.databinding.FragmentHomeBinding
import com.example.kilokapp.databinding.FragmentIniciarSesionBinding

class FragmentHome : Fragment() {

    private lateinit var navController: NavController
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // aqui se llama al codigo de la app.
        //navController = Navigation.findNavController(view) // metodo mas recomndable.
        IniciarUI()
    }

    private fun IniciarUI() {
        replaceFragment(FragmentExcercices())

        binding.bottomNavView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.itemEjercicios -> replaceFragment(FragmentExcercices())
                R.id.itemRecetas -> replaceFragment(FragmentRecipes())
                R.id.itemDiagnostico -> replaceFragment(FragmentDiagnostic())

                else -> {

                }
            }
            true
        }
    }


    // intercambia entre fragmentos.
    private fun replaceFragment(fragment : Fragment) {
        val fragmentManager = activity?.supportFragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.frame_layout_home, fragment)
        fragmentTransaction?.commit()
    }
}