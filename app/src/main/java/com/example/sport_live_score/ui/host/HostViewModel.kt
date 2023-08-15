package com.example.sport_live_score.ui.host

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sport_live_score.util.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HostViewModel @Inject constructor() : ViewModel() {
    private val _stateHost = MutableStateFlow<Screen>(Screen.HOME)
    val stateHost: StateFlow<Screen> = _stateHost
    fun loadState(screen: Screen) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateHost.emit(screen)
        }
    }

}