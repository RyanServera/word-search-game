package com.example.wordsearch.screens.title

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TitleViewModel: ViewModel() {
    private val _eventShowHowToPlay = MutableLiveData<Boolean>()
    val eventShowHowToPlay: LiveData<Boolean>
        get() = _eventShowHowToPlay

    private val _eventStartGame = MutableLiveData<Boolean>()
    val eventStartGame: LiveData<Boolean>
        get() = _eventStartGame

    init {
        _eventShowHowToPlay.value = false
        _eventStartGame.value = false
    }

    fun startGame() {
        _eventStartGame.value = true
    }

    fun startGameCompleted() {
        _eventStartGame.value = false
    }

    fun showHowToPlay() {
        _eventShowHowToPlay.value = true
    }

    fun showHowToPlayCompleted() {
        _eventShowHowToPlay.value = false
    }
}