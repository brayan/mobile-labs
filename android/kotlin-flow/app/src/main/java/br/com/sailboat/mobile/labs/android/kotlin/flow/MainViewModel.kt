package br.com.sailboat.mobile.labs.android.kotlin.flow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    init {
        collectFlow()
    }

    // Hot Flow: Emit values even when there no collectors
    // Cold Flow: Does nothing as long as there are no subscribers
    // This is a cold flow:
    val countDownFlow = flow {
        val startingValue = 10
        var currentValue = startingValue

        emit(startingValue)
        while (currentValue > 0) {
            delay(1000L)
            currentValue--
            emit(currentValue)
        }
    }

    private fun collectFlow() {
        viewModelScope.launch {
//            countDownFlow.collect { time ->
//                println("The current time is $time")
//            }

            // will collect only the latest value ignoring the previous ones
            countDownFlow.collectLatest { time ->
                delay(1500L)
                println("The current time is $time")
            }
        }
    }
}