package com.example.ejercicio.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.ejercicio.databinding.JugadorFragmentBinding
import com.example.ejercicio.entities.Jugador
import com.example.ejercicio.viewmodels.JugadorViewModel

class JugadorFragment : Fragment() {

    companion object {
        fun newInstance() = JugadorFragment()
    }

    private lateinit var viewModel: JugadorViewModel
    private lateinit var binding: JugadorFragmentBinding
    private lateinit var jugador: Jugador

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = JugadorFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        jugador = JugadorFragmentArgs.fromBundle(requireArguments()).jugador
        binding.nombre.text = "Jugador: " + jugador.nombre
        binding.equipo.text = "Equipo: " + jugador.equipo
        binding.numero.text = "Número: " + jugador.numero

        Glide
            .with(requireContext())
            .load(jugador.urlImage)
            .centerInside()
            .into(binding.imagenJugadorDetalle);
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(JugadorViewModel::class.java)
        // TODO: Use the ViewModel
    }

}