package com.example.recyclerbottom.adapter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewHeroViewModel : ViewModel(){
    var name = MutableLiveData<String>()
    var realname = MutableLiveData<String>()
    var publisher = MutableLiveData<String>()
}