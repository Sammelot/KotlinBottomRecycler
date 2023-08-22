package com.example.recyclerbottom.adapter

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.recyclerbottom.SuperHero
import com.example.recyclerbottom.databinding.ItemSuperheroBinding

class SuperHeroViewHolder(view: View) : ViewHolder(view) {

    val binding = ItemSuperheroBinding.bind(view)

    fun render(superHeroModel: SuperHero, onClickListener: (SuperHero) -> Unit) {
        binding.tvSuperHeroName.text = superHeroModel.superHero
        binding.tvSuperHeroRealName.text = superHeroModel.realName
        binding.tvSuperHeroPublisher.text = superHeroModel.publisher
        Glide.with(binding.ivSuperHero.context).load(superHeroModel.photo).into(binding.ivSuperHero)
        itemView.setOnClickListener { onClickListener(superHeroModel) }
    }
}