package com.example.wordsearch.screens.endgame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.wordsearch.R
import com.example.wordsearch.databinding.EndgameFragmentBinding

class EndgameFragment: Fragment(){

    private lateinit var binding: EndgameFragmentBinding
    private lateinit var endgameViewModel: EndgameViewModel
    private lateinit var endgameViewModelFactory: EndgameViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.endgame_fragment,
            container,
            false
        )

        val endgameFragmentArgs by navArgs<EndgameFragmentArgs>()

        endgameViewModelFactory = EndgameViewModelFactory(endgameFragmentArgs.finalScore)

        endgameViewModel = ViewModelProvider(this, endgameViewModelFactory).get(EndgameViewModel::class.java)

        binding.endgameViewModel = endgameViewModel
        binding.lifecycleOwner = this

        endgameViewModel.eventPlayAgain.observe(viewLifecycleOwner, {isPlayingAgain ->
            if (isPlayingAgain) {
                findNavController().navigate(EndgameFragmentDirections.actionEndgameFragmentToGameFragment())
                endgameViewModel.playAgainCompleted()
            }
        })

        endgameViewModel.eventExit.observe(viewLifecycleOwner, {isExitingGame ->
            if (isExitingGame) {
                findNavController().navigate(EndgameFragmentDirections.actionEndgameFragmentToTitleFragment2())
                endgameViewModel.exitGameCompleted()
            }
        })

        return binding.root
    }
}