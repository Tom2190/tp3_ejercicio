package com.example.ejercicio.fragments

import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.ejercicio.databinding.ProfileFragmentBinding
import com.example.ejercicio.viewmodels.JugadorViewModel

class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var viewModel: JugadorViewModel
    private lateinit var binding: ProfileFragmentBinding
    private var urlImageProfile = "https://conceptodefinicion.de/wp-content/uploads/2015/03/hombre.jpg"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = ProfileFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        Glide
            .with(requireContext())
            .load(urlImageProfile)
            .centerInside()
            .into(binding.imagenProfile)

        binding.nombreProfile.text = "Nombre: " + LoginFragment.newInstance().getUser()?.name.toString()
        binding.passwordProfile.text = "Password: " + LoginFragment.newInstance().getUser()?.password.toString()

        val prefs = PreferenceManager.getDefaultSharedPreferences(requireContext())

        if (prefs.getBoolean("dark_mode",true)) {
            binding.root.setBackgroundColor(Color.parseColor("#000000"))
            binding.nombreProfile.setTextColor(Color.parseColor("#ffffff"))
            binding.passwordProfile.setTextColor(Color.parseColor("#ffffff"))
        }

        if (prefs.getBoolean("dark_mode",false)) {
            binding.root.setBackgroundColor(Color.parseColor("#ffffff"))
            binding.nombreProfile.setTextColor(Color.parseColor("#000000"))
            binding.passwordProfile.setTextColor(Color.parseColor("#000000"))
        }

        binding.btnSettings.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileFragmentToSettingsActivity2()
            findNavController().navigate(action)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(JugadorViewModel::class.java)
        // TODO: Use the ViewModel
    }

}