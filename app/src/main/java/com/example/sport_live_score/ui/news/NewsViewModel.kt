package com.example.sport_live_score.ui.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sport_live_score.util.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor() : ViewModel() {
    private val _stateNote = MutableStateFlow(Note.OFF)
    val stateNote: StateFlow<Note> = _stateNote

    fun loadStateNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateNote.emit(note)
        }
    }

}