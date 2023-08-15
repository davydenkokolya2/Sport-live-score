package com.example.sport_live_score.ui.live_score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.sport_live_score.R
import com.example.sport_live_score.databinding.FragmentLiveScoreBinding
import com.example.sport_live_score.ui.host.HostViewModel
import com.example.sport_live_score.util.Constant
import com.example.sport_live_score.util.LiveScore
import com.example.sport_live_score.util.Screen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LiveScoreFragment : Fragment() {

    private lateinit var binding: FragmentLiveScoreBinding
    private val hostViewModel: HostViewModel by activityViewModels()
    private val liveScoreViewModel: LiveScoreViewModel by activityViewModels()
    private var flag = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLiveScoreBinding.inflate(inflater, container, false)
        binding.btnHome2.setOnClickListener {
            hostViewModel.loadState(Screen.HOME)
        }
        lifecycleScope.launch {
            liveScoreViewModel.stateLiveScore.collect {
                binding.btnStatistic.setImageResource(R.drawable.icon_statistic)
                binding.btnInfo.setImageResource(R.drawable.icon_info)
                binding.imageView31.visibility = View.INVISIBLE
                binding.imageView2.visibility = View.INVISIBLE
                binding.ivStatistic.visibility = View.INVISIBLE
                when (it) {
                    LiveScore.STATISTIC -> {
                        binding.btnStatistic.setImageResource(R.drawable.icon_statistic_yes)
                        binding.imageView2.visibility = View.VISIBLE
                        binding.ivStatistic.visibility = View.VISIBLE
                    }

                    LiveScore.INFO -> {
                        binding.btnInfo.setImageResource(R.drawable.icon_info_yes)
                        binding.imageView31.visibility = View.VISIBLE
                        if (!flag)
                        {
                            for (i in Constant.FIVE downTo Constant.ZERO) {
                                flag = true
                                when (i) {
                                    Constant.FIVE -> binding.ivCard1.visibility = View.VISIBLE
                                    Constant.THOUR -> binding.ivCard2.visibility = View.VISIBLE
                                    Constant.THREE -> binding.ivCard3.visibility = View.VISIBLE
                                    Constant.TWO -> binding.ivCard4.visibility = View.VISIBLE
                                    Constant.ONE -> binding.ivCard5.visibility = View.VISIBLE
                                    Constant.ZERO -> binding.ivCard6.visibility = View.VISIBLE
                                }
                                delay(Constant.TWO_THOUSAND)
                            }
                        }
                    }
                }
            }
        }
        binding.btnStatistic.setOnClickListener {
            liveScoreViewModel.loadState(LiveScore.STATISTIC)
        }
        binding.btnInfo.setOnClickListener {
            liveScoreViewModel.loadState(LiveScore.INFO)
        }
        return binding.root
    }


}