package com.ralphmarondev.cowntdown.features.moo.presentation

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ralphmarondev.cowntdown.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.random.Random

class MooViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MooViewModel::class.java)) {
            return MooViewModel(context) as T
        }
        throw IllegalStateException("Unknown ViewModel class")
    }
}

@SuppressLint("StaticFieldLeak")
class MooViewModel(
    private val context: Context
) : ViewModel() {

    private val allFunFactIds = listOf(
        R.string.fun_fact_1,
        R.string.fun_fact_2,
        R.string.fun_fact_3,
        R.string.fun_fact_4,
        R.string.fun_fact_5,
        R.string.fun_fact_6,
        R.string.fun_fact_7,
        R.string.fun_fact_8,
        R.string.fun_fact_9,
        R.string.fun_fact_10,
        R.string.fun_fact_11,
        R.string.fun_fact_12,
        R.string.fun_fact_13,
        R.string.fun_fact_14,
        R.string.fun_fact_15,
        R.string.fun_fact_16,
        R.string.fun_fact_17,
        R.string.fun_fact_18,
        R.string.fun_fact_19,
        R.string.fun_fact_20,
        R.string.fun_fact_21,
        R.string.fun_fact_22,
        R.string.fun_fact_23,
        R.string.fun_fact_24,
        R.string.fun_fact_25,
        R.string.fun_fact_26,
        R.string.fun_fact_27,
        R.string.fun_fact_28,
        R.string.fun_fact_29,
        R.string.fun_fact_30,
        R.string.fun_fact_31,
        R.string.fun_fact_32,
        R.string.fun_fact_33,
        R.string.fun_fact_34,
        R.string.fun_fact_35,
        R.string.fun_fact_36,
        R.string.fun_fact_37,
        R.string.fun_fact_38,
        R.string.fun_fact_39,
        R.string.fun_fact_40,
        R.string.fun_fact_41,
        R.string.fun_fact_42,
        R.string.fun_fact_43,
        R.string.fun_fact_44,
        R.string.fun_fact_45,
        R.string.fun_fact_46,
        R.string.fun_fact_47,
        R.string.fun_fact_48,
        R.string.fun_fact_49,
        R.string.fun_fact_50,
        R.string.fun_fact_51,
        R.string.fun_fact_52,
        R.string.fun_fact_53,
        R.string.fun_fact_54,
        R.string.fun_fact_55,
        R.string.fun_fact_56,
        R.string.fun_fact_57,
        R.string.fun_fact_58,
        R.string.fun_fact_59,
        R.string.fun_fact_60,
        R.string.fun_fact_61,
        R.string.fun_fact_62,
        R.string.fun_fact_63,
        R.string.fun_fact_64,
        R.string.fun_fact_65,
        R.string.fun_fact_66,
        R.string.fun_fact_67,
        R.string.fun_fact_68,
        R.string.fun_fact_69,
        R.string.fun_fact_70,
        R.string.fun_fact_71,
        R.string.fun_fact_72,
        R.string.fun_fact_73,
        R.string.fun_fact_74,
        R.string.fun_fact_75,
        R.string.fun_fact_76,
        R.string.fun_fact_77,
        R.string.fun_fact_78,
        R.string.fun_fact_79,
        R.string.fun_fact_80,
        R.string.fun_fact_81,
        R.string.fun_fact_82,
        R.string.fun_fact_83,
        R.string.fun_fact_84,
        R.string.fun_fact_85
    )
    private val shownFunFacts = mutableListOf<Int>()

    private val _funFact = MutableStateFlow("")
    val funFact: StateFlow<String> get() = _funFact

    init {
        getRandomFunFact()
    }

    fun getRandomFunFact() {

        if (shownFunFacts.size == allFunFactIds.size) {
            shownFunFacts.clear()
        }
        val remainingFacts = allFunFactIds.filterNot { shownFunFacts.contains(it) }
        val randomFactId = remainingFacts[Random.nextInt(remainingFacts.size)]

        _funFact.value = context.getString(randomFactId)
        shownFunFacts.add(randomFactId)
    }
}