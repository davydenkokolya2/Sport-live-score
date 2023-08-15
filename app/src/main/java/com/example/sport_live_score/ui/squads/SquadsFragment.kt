package com.example.sport_live_score.ui.squads

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.sport_live_score.R
import com.example.sport_live_score.databinding.FragmentSquadsBinding
import com.example.sport_live_score.ui.host.HostViewModel
import kotlin.random.Random

class SquadsFragment : Fragment() {

    private lateinit var binding: FragmentSquadsBinding
    private val hostViewModel: HostViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSquadsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        when (Random.nextInt(3)) {
            0 -> binding.imageView5.setImageResource(R.drawable.icon_football_field)
            1 -> binding.imageView5.setImageResource(R.drawable.icon_football_field_v2)
            2 -> binding.imageView5.setImageResource(R.drawable.icon_football_field_v3)
        }
        super.onViewCreated(view, savedInstanceState)
    }
}