package com.example.recyclerbottom.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerbottom.R
import com.example.recyclerbottom.SuperHero

class SuperHeroAdapter(private val superherolist:List<SuperHero>, private val onClickListener:(SuperHero) -> Unit) : RecyclerView.Adapter<SuperHeroViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperHeroViewHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false))
    }

    override fun getItemCount(): Int = superherolist.size

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        val item = superherolist[position]
        holder.render(item, onClickListener)
    }
}