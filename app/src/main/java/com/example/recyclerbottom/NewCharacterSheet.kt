package com.example.recyclerbottom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.recyclerbottom.adapter.NewHeroViewModel
import com.example.recyclerbottom.databinding.FragmentNewCharacterSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NewCharacterSheet : BottomSheetDialogFragment() {


    private lateinit var binding: FragmentNewCharacterSheetBinding
    private lateinit var newHeroViewModel: NewHeroViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()
        newHeroViewModel = ViewModelProvider(activity)[NewHeroViewModel::class.java]
        binding.btnGuardar.setOnClickListener {
            saveAction()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewCharacterSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun saveAction() {
        newHeroViewModel.name.value = binding.etHeroName.text.toString()
        newHeroViewModel.realname.value = binding.etHeroRealName.text.toString()
        newHeroViewModel.publisher.value = binding.etHeroPublisher.text.toString()
        binding.etHeroName.setText("")
        binding.etHeroRealName.setText("")
        binding.etHeroPublisher.setText("")
        dismiss()
    }

}