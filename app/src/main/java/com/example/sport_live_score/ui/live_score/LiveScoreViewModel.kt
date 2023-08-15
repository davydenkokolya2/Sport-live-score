package com.example.sport_live_score.ui.live_score

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sport_live_score.util.LiveScore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LiveScoreViewModel : ViewModel() {
    private val _stateLiveScore = MutableStateFlow<LiveScore>(LiveScore.STATISTIC)
    val stateLiveScore: StateFlow<LiveScore> = _stateLiveScore
    fun loadState(liveScore: LiveScore) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateLiveScore.emit(liveScore)
        }
    }

}