package com.example.recyclerbottom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerbottom.adapter.NewHeroViewModel
import com.example.recyclerbottom.adapter.SuperHeroAdapter
import com.example.recyclerbottom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var newHeroViewModel: NewHeroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()

        newHeroViewModel = ViewModelProvider(this)[NewHeroViewModel::class.java]
        binding.foatMain.setOnClickListener{
            NewCharacterSheet().show(supportFragmentManager, "newHeroTag")
        }

        newHeroViewModel.name.observe(this){
            binding.tvSuperName.text= String.format("Nombre de heroe: %s", it)
        }
        newHeroViewModel.realname.observe(this){
            binding.tvSuperRealName.text= String.format("Nombre real: %s", it)
        }
        newHeroViewModel.name.observe(this){
            binding.tvSuperPublisher.text= String.format("Publisher: %s", it)
        }
    }

    private fun initRecyclerView() {
        val manager = GridLayoutManager(this, 2)
        binding.recyclerSuperhero.layoutManager = manager
        binding.recyclerSuperhero.adapter =
            SuperHeroAdapter(SuperHeroProvider.superheroList, { onItemSelected(it) })

    }

    fun onItemSelected(superhero: SuperHero) {
        Toast.makeText(this, superhero.superHero, Toast.LENGTH_SHORT).show()
    }
}