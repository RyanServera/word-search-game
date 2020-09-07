package com.example.wordsearch.screens.endgame

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class EndgameViewModelFactory(private val finalScore: Int): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EndgameViewModel::class.java)) {
            return EndgameViewModel(finalScore) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}