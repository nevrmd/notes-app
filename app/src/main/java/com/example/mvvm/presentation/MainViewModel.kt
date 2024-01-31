package com.example.mvvm.presentation

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    init {
        Log.e("AAA", "VM")
    }

    override fun onCleared() {
        Log.e("AAA", "VM clear")
        super.onCleared()
    }
}