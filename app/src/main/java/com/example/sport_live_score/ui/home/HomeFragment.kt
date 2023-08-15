package com.example.sport_live_score.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.sport_live_score.R
import com.example.sport_live_score.databinding.FragmentHomeBinding
import com.example.sport_live_score.ui.host.HostViewModel
import com.example.sport_live_score.util.HomeButtons
import com.example.sport_live_score.util.Note
import com.example.sport_live_score.util.Screen
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val hostViewModel: HostViewModel by activityViewModels()
    private val homeViewModel: HomeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.btnSquads.setOnClickListener {
            hostViewModel.loadState(Screen.SQUADS)
        }
        binding.btnHome.setOnClickListener {
            hostViewModel.loadState(Screen.HOME)
        }
        binding.btnStar.setOnClickListener {
            hostViewModel.loadState(Screen.LIVE_SCORE)
        }
        binding.btnNBA.setOnClickListener {
            homeViewModel.loadState(HomeButtons.NBA)
        }
        binding.btnAdd.setOnClickListener {
            homeViewModel.loadState(HomeButtons.ADD)
        }
        binding.btnNFL.setOnClickListener {
            homeViewModel.loadState(HomeButtons.NFL)
        }
        binding.btnFIVB.setOnClickListener {
            homeViewModel.loadState(HomeButtons.FIVB)
        }
        binding.btnFIFA.setOnClickListener {
            homeViewModel.loadState(HomeButtons.FIFA)
        }
        binding.btnBWF.setOnClickListener {
            homeViewModel.loadState(HomeButtons.BWF)
        }
        lifecycleScope.launch {
            homeViewModel.stateHome.collect {
                binding.btnAdd.setImageResource(R.drawable.icon_button_add)
                binding.btnBWF.setImageResource(R.drawable.icon_button_bwf)
                binding.btnFIVB.setImageResource(R.drawable.icon_button_fivb)
                binding.btnNBA.setImageResource(R.drawable.icon_button_nba)
                binding.btnNFL.setImageResource(R.drawable.icon_button_nfl)
                binding.btnFIFA.setImageResource(R.drawable.icon_button_fifa_no)
                when (it) {
                    HomeButtons.FIFA -> binding.btnFIFA.setImageResource(R.drawable.icon_button_fifa)
                    HomeButtons.ADD -> binding.btnAdd.setImageResource(R.drawable.icon_button_add_yes)
                    HomeButtons.BWF -> binding.btnBWF.setImageResource(R.drawable.icon_button_bwf_yes)
                    HomeButtons.NBA -> binding.btnNBA.setImageResource(R.drawable.icon_button_nba_yes)
                    HomeButtons.NFL -> binding.btnNFL.setImageResource(R.drawable.icon_button_nfl_yes)
                    HomeButtons.FIVB -> binding.btnFIVB.setImageResource(R.drawable.icon_button_fivb_yes)
                }
            }
        }
        lifecycleScope.launch {
            homeViewModel.stateNote1.collect {
                when(it) {
                    Note.OFF -> binding.btnNoteCard1.setImageResource(R.drawable.icon_note)
                    Note.ON -> binding.btnNoteCard1.setImageResource(R.drawable.icon_note_yes)
                }
            }
        }
        lifecycleScope.launch {
            homeViewModel.stateNote2.collect {
                when(it) {
                    Note.OFF -> binding.btnNoteCard2.setImageResource(R.drawable.icon_note)
                    Note.ON -> binding.btnNoteCard2.setImageResource(R.drawable.icon_note_yes)
                }
            }
        }

        binding.btnNoteCard1.setOnClickListener {
           if (homeViewModel.stateNote1.value == Note.ON)
               homeViewModel.loadStateNote1(Note.OFF)
            else
                homeViewModel.loadStateNote1(Note.ON)
        }

        binding.btnNoteCard2.setOnClickListener {
            if (homeViewModel.stateNote2.value == Note.ON)
                homeViewModel.loadStateNote2(Note.OFF)
            else
                homeViewModel.loadStateNote2(Note.ON)
        }
        return binding.root
    }
}