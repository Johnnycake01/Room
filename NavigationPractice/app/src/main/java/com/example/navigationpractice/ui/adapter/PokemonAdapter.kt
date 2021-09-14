package com.example.navigationpractice.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.navigationpractice.R
import com.example.navigationpractice.model.Results
import com.example.navigationpractice.util.TAG
import com.example.navigationpractice.util.getNumber

class PokemonAdapter(private val context: Context):RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {
    private var items:MutableList<Results> = mutableListOf()
    inner class PokemonViewHolder(v: View):RecyclerView.ViewHolder(v){
        val imageView:ImageView = v.findViewById(R.id.ivPokemonImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_rv_layout,
           parent,false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val itemPosition = items[position]
        val getPosition = getNumber(itemPosition.url)


        Glide.with(context)
            .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$getPosition.png")
            .centerCrop()
            .circleCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addNewPokemon(pokemon:List<Results>){
        items.clear()
        items.addAll(pokemon)
        notifyDataSetChanged()
    }
}