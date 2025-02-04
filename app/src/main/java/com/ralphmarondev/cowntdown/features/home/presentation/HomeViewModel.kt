package com.ralphmarondev.cowntdown.features.home.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.media.MediaPlayer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.ralphmarondev.cowntdown.R
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class HomeViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(context) as T
        }
        throw IllegalStateException("Unknown ViewModel class")
    }
}

@SuppressLint("StaticFieldLeak")
class HomeViewModel(
    private val context: Context
) : ViewModel() {

    private val _isFirstDayOfMonth = MutableStateFlow(false)
    val isFirstDayOfMonth: StateFlow<Boolean> get() = _isFirstDayOfMonth

    private val _daysUntilNextFirstDay = MutableStateFlow(0)
    val daysUntilNextFirstDay: StateFlow<Int> get() = _daysUntilNextFirstDay

    private val _typewriterText = MutableStateFlow("")
    val typewriterText: StateFlow<String> get() = _typewriterText

    private val _currentDate = MutableStateFlow("")
    val currentDate: StateFlow<String> get() = _currentDate

    private var mediaPlayer: MediaPlayer? = null
    private var typewriterJob: Job? = null

    init {
        checkFirstDayOfMonth()
        calculateDaysUntilNextFirstDay()
        getCurrentDate()
    }

    private fun checkFirstDayOfMonth() {
        val currentDate = LocalDate.now()
        _isFirstDayOfMonth.value = currentDate.dayOfMonth == 1
    }

    private fun calculateDaysUntilNextFirstDay() {
        val currentDate = LocalDate.now()

        val nextFirstDay = if (currentDate.dayOfMonth == 1) {
            currentDate.plusMonths(1).withDayOfMonth(1)
        } else {
            currentDate.withDayOfMonth(1).plusMonths(1)
        }

        val daysUntilNextFirst =
            java.time.temporal.ChronoUnit.DAYS.between(currentDate, nextFirstDay)
        _daysUntilNextFirstDay.value = daysUntilNextFirst.toInt()
    }

    private fun getCurrentDate() {
        val dateNow = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy")
        _currentDate.value = dateNow.format(formatter)
    }

    fun startTypewriterEffect() {
        val textToShow = "Wake up, it's the first of the month!"
        _typewriterText.value = ""

        typewriterJob?.cancel()
        typewriterJob = viewModelScope.launch {
            while (true) {
                val builder = StringBuilder()
                for (char in textToShow) {
                    builder.append(char)
                    _typewriterText.value = builder.toString()
                    delay(10)
                }
                delay(5000)
                _typewriterText.value = ""
            }
        }
    }

    fun playSound() {
        if (_isFirstDayOfMonth.value && mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(context, R.raw.first_day_of_month_sound).apply {
                start()
                setOnCompletionListener {
                    it.release()
                    mediaPlayer = null
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        mediaPlayer?.apply {
            stop()
            release()
        }
        mediaPlayer = null
        typewriterJob?.cancel()
    }
}