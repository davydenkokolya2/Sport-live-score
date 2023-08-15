package com.example.sport_live_score.ui.host

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.sport_live_score.R
import com.example.sport_live_score.databinding.FragmentHostBinding
import com.example.sport_live_score.ui.home.HomeFragment
import com.example.sport_live_score.ui.live_score.LiveScoreFragment
import com.example.sport_live_score.ui.news.NewsFragment
import com.example.sport_live_score.ui.squads.SquadsFragment
import com.example.sport_live_score.util.Screen
import kotlinx.coroutines.launch

class HostFragment : Fragment() {

    private lateinit var binding: FragmentHostBinding
    private val hostViewModel: HostViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHostBinding.inflate(inflater, container, false)

        binding.btnHostNews.setOnClickListener {
            hostViewModel.loadState(Screen.NEWS)
        }

        binding.btnHostBack.setOnClickListener {
            hostViewModel.loadState(Screen.HOME)
        }
        lifecycleScope.launch {
            hostViewModel.stateHost.collect {
                binding.btnHostBack.visibility = View.INVISIBLE
                binding.btnHostBack.visibility = View.INVISIBLE

                when (it) {
                    Screen.HOME -> {
                        replaceFragment(HomeFragment())
                        binding.btnHostNews.visibility = View.VISIBLE
                        binding.tvTitle.setText(R.string.home)
                    }

                    Screen.NEWS -> {
                        replaceFragment(NewsFragment())
                        binding.btnHostBack.visibility = View.VISIBLE
                        binding.tvTitle.setText(R.string.news)
                    }

                    Screen.LIVE_SCORE -> {
                        replaceFragment(LiveScoreFragment())
                        binding.btnHostBack.visibility = View.VISIBLE
                        binding.tvTitle.setText(R.string.live_score)
                    }

                    Screen.SQUADS -> {
                        replaceFragment(SquadsFragment())
                        binding.btnHostBack.visibility = View.VISIBLE
                        binding.tvTitle.setText(R.string.squads)
                    }

                    else -> {}
                }
            }
        }


        return binding.root
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }
}