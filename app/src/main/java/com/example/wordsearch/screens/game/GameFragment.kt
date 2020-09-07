package com.example.wordsearch.screens.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.wordsearch.R
import com.example.wordsearch.databinding.GameFragmentBinding

class GameFragment: Fragment() {

    private lateinit var binding: GameFragmentBinding
    private lateinit var gameViewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.game_fragment,
            container,
            false
        )

        gameViewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        binding.gameViewModel = gameViewModel
        binding.lifecycleOwner = this

        gameViewModel.eventGameOver.observe(viewLifecycleOwner, {isGameOver ->
            if (isGameOver) {
                findNavController(this).navigate(GameFragmentDirections.actionGameFragmentToEndgameFragment())
                gameViewModel.gameOverCompleted()
            }
        })

        return binding.root
    }

}
