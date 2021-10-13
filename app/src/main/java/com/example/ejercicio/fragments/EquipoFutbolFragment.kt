package com.example.ejercicio.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejercicio.adapters.EquipoFutbolAdapter
import com.example.ejercicio.databinding.EquipoFragmentBinding
import com.example.ejercicio.repository.EquipoFutbolRepository
import com.example.ejercicio.viewmodels.EquipoFutbolViewModel

class EquipoFutbolFragment : Fragment() {

    companion object {
        fun newInstance() = EquipoFutbolFragment()
    }

    private lateinit var viewModel: EquipoFutbolViewModel
    private val equipoFutbolRepository = EquipoFutbolRepository()
    private lateinit var binding: EquipoFragmentBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = EquipoFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        binding.recEquipo.setHasFixedSize(true)
        binding.recEquipo.layoutManager = LinearLayoutManager(context)
        binding.recEquipo.adapter = EquipoFutbolAdapter(equipoFutbolRepository.getEquipo(),requireContext()) {
            onItemClick(it)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EquipoFutbolViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun onItemClick(position : Int) {
        val action = EquipoFutbolFragmentDirections.actionEquipoFutbolToJugadorFragment(equipoFutbolRepository.getEquipo()[position])
        findNavController().navigate(action)
    }
}