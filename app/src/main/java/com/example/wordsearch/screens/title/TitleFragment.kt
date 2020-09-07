package com.example.wordsearch.screens.title

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.wordsearch.R
import com.example.wordsearch.databinding.TitleFragmentBinding

class TitleFragment : Fragment() {

    private lateinit var binding: TitleFragmentBinding
    private lateinit var titleViewModel: TitleViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.title_fragment,
            container,
            false
        )

        titleViewModel = ViewModelProvider(this).get(TitleViewModel::class.java)

        binding.titleViewModel = titleViewModel
        binding.lifecycleOwner = this

        // State observer for the how to play fragment event
        titleViewModel.eventShowHowToPlay.observe(viewLifecycleOwner, { isLearningHowToPlay ->
            if(isLearningHowToPlay) {
                findNavController(this).navigate(TitleFragmentDirections.actionTitleFragmentToInfoFragment())
                titleViewModel.showHowToPlayCompleted()
            }
        })

        // State observer for the game fragment event
        titleViewModel.eventStartGame.observe(viewLifecycleOwner, { isPlayingGame ->
            if (isPlayingGame) {
                findNavController(this).navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
                titleViewModel.startGameCompleted()
            }
        })

        return binding.root
    }
}