package com.ralphmarondev.cowntdown.features.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate

class HomeViewModel : ViewModel() {

    private val _isFirstDayOfMonth = MutableStateFlow(false)
    val isFirstDayOfMonth: StateFlow<Boolean> get() = _isFirstDayOfMonth

    private val _daysUntilNextFirstDay = MutableStateFlow(0)
    val daysUntilNextFirstDay: StateFlow<Int> get() = _daysUntilNextFirstDay

    private val _typewriterText = MutableStateFlow("")
    val typewriterText: StateFlow<String> get() = _typewriterText

    init {
        checkFirstDayOfMonth()
        calculateDaysUntilNextFirstDay()
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

    fun startTypewriterEffect() {
        val textToShow = "Hey, it's the first of the month!"
        _typewriterText.value = ""
        viewModelScope.launch {
            for (i in textToShow.indices) {
                delay(100)
                _typewriterText.value += textToShow[i]
            }
        }
    }
}