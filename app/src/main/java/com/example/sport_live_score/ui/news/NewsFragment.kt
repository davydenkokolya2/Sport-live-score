package com.example.sport_live_score.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.sport_live_score.R
import com.example.sport_live_score.databinding.FragmentNewsBinding
import com.example.sport_live_score.util.Note
import kotlinx.coroutines.launch

class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding
    private val newsViewModel: NewsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        binding.btnNoteNFL.setOnClickListener {
            if (newsViewModel.stateNote.value == Note.ON)
                newsViewModel.loadStateNote(Note.OFF)
            else
                newsViewModel.loadStateNote(Note.ON)
        }
        lifecycleScope.launch {
            newsViewModel.stateNote.collect {
                when(it) {
                    Note.OFF -> binding.btnNoteNFL.setImageResource(R.drawable.icon_note)
                    Note.ON -> binding.btnNoteNFL.setImageResource(R.drawable.icon_note_yes)
                }
            }
        }
        return binding.root
    }
}