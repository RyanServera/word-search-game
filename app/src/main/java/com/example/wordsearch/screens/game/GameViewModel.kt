package com.example.wordsearch.screens.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    private val _eventGameOver = MutableLiveData<Boolean>()
    val eventGameOver: LiveData<Boolean>
        get() = _eventGameOver

    fun gameOver() {
        _eventGameOver.value = true
    }

    fun gameOverCompleted() {
        _eventGameOver.value = false
    }
}