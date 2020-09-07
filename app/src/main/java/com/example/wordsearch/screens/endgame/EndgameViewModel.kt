package com.example.wordsearch.screens.endgame

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EndgameViewModel(finalScore: Int): ViewModel() {
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    private val _eventPlayAgain = MutableLiveData<Boolean>()
    val eventPlayAgain: LiveData<Boolean>
        get() = _eventPlayAgain

    private val _eventExit = MutableLiveData<Boolean>()
    val eventExit: LiveData<Boolean>
        get() = _eventExit

    init {
        _score.value = finalScore
        _eventPlayAgain.value = false
        _eventExit.value = false
    }

    fun playAgain() {
        _eventPlayAgain.value = true
    }

    fun playAgainCompleted() {
        _eventPlayAgain.value = false
    }

    fun exitGame() {
        _eventExit.value = true
    }

    fun exitGameCompleted() {
        _eventExit.value = false
    }
}