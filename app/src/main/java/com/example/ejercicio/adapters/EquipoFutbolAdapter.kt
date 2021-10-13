package com.example.ejercicio.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ejercicio.databinding.ItemEquipoBinding
import com.example.ejercicio.entities.Jugador


class EquipoFutbolAdapter (var jugadorList : MutableList<Jugador>,
                           var context : Context,
                           val onItemClick : (Int) -> Unit)
    : RecyclerView.Adapter<EquipoFutbolAdapter.EquipoFutbolHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EquipoFutbolHolder {
        val binding =ItemEquipoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return EquipoFutbolHolder(binding)
    }

    class EquipoFutbolHolder (binding: ItemEquipoBinding ) : RecyclerView.ViewHolder(binding.root) {

        val binding : ItemEquipoBinding = binding


        fun setJugador(nombre : String) {
            binding.txtJugador.text = nombre
        }

        fun getCardView () : CardView {
            return binding.itemCard
        }

        fun getImage () : ImageView {
            return binding.imagenJugador
        }

    }

    override fun getItemCount(): Int {
        return jugadorList.size
    }

    override fun onBindViewHolder(holder: EquipoFutbolHolder, position: Int) {
        holder.setJugador(jugadorList[position].nombre)
        holder.getCardView().setOnClickListener {
            onItemClick(position)
        }

        Glide
           .with(context)
           .load(jugadorList[position].urlImage)
           .centerInside()
           .into(holder.getImage());
    }
}