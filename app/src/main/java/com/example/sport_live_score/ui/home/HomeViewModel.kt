package com.example.sport_live_score.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sport_live_score.util.HomeButtons
import com.example.sport_live_score.util.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    private val _stateHome = MutableStateFlow(HomeButtons.FIFA)
    val stateHome: StateFlow<HomeButtons> = _stateHome

    fun loadState(homeButtons: HomeButtons) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateHome.emit(homeButtons)
        }
    }

    private val _stateNote1 = MutableStateFlow(Note.OFF)
    val stateNote1: StateFlow<Note> = _stateNote1

    fun loadStateNote1(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateNote1.emit(note)
        }
    }
    private val _stateNote2 = MutableStateFlow(Note.OFF)
    val stateNote2: StateFlow<Note> = _stateNote2

    fun loadStateNote2(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateNote2.emit(note)
        }
    }
}