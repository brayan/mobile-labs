package br.com.sailboat.mobile.labs.android.kotlin.flow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

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

    private val _stateFlow = MutableStateFlow(0)
    val stateFlow = _stateFlow.asStateFlow()

    private val _sharedFlow = MutableSharedFlow<Int>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    init {
//        collectFlowWithConflate()
        viewModelScope.launch {
            sharedFlow.collect {
                delay(2000L)
                println("FIRST FLOW: The received number is $it")
            }
        }
        viewModelScope.launch {
            sharedFlow.collect {
                delay(3000L)
                println("SECOND FLOW: The received number is $it")
            }
        }

        squareNumber(3)
    }

    fun incrementCounter() {
        _stateFlow.value += 1
    }

    fun squareNumber(number: Int) {
        viewModelScope.launch {
            _sharedFlow.emit(number * number)
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

    private fun collectFlowWithOperators() {
        viewModelScope.launch {
            countDownFlow.filter { time ->
                time % 2 == 0
            }.map { time ->
                time * time
            }.onEach { time ->
                println(time)
            }.collect { time -> // collect just make sure that the flow is finished
                println("The current time is $time")
            }
        }
    }

    private fun collectFlowWithCountTerminalOperator() {
        viewModelScope.launch {
            val count = countDownFlow.filter { time ->
                time % 2 == 0
            }.map { time ->
                time * time
            }.onEach { time ->
                println(time)
            }.count {  // count the values that matches specific conditions
                it % 2 == 0
            }

            println("The count is $count")
        }
    }

    private fun collectFlowWithReduceTerminalOperator() {
        viewModelScope.launch {
            val reduceResult =
                countDownFlow.reduce { accumulator, value ->  // reduce will now be executed for every single emition
                    // accumulator: in the first iteration, accumulator is initiated with the first value: 10. From the second iteration,
                    // accumulator will have the integer returned on reduce filter
                    // value: value is always initiated from the second value: 9, to 8, 7, 6, 5, 4, 3, 2, 1 and 0
                    println("reduce accumulator: $accumulator, reduce value: $value")
                    accumulator + value
                }
            println("reduce result: $reduceResult")
        }
    }

    private fun collectFlowWithFoldTerminalOperator() {
        viewModelScope.launch {
            // same as reduce but with a initial accumulator value
            val foldResult = countDownFlow.fold(initial = 100) { accumulator, value ->
                println("fold accumulator: $accumulator, fold value: $value")
                accumulator + value
            }
            println("fold result: $foldResult")
        }
    }

    private fun collectTwoFlowWithFlatMapConcat() {
        val flow1 = flow {
            emit(1)
            delay(500L)
            emit(2)
        }

        viewModelScope.launch {
            flow1.flatMapConcat { value ->
                flow {
                    emit(value + 1)
                    delay(500L)
                    emit(value + 2)
                }
            }.collect { value ->
                println("The value is $value")
            }
        }
    }

    private fun collectFlowWithBuffer() {
        val flow = flow {
            delay(250L)
            emit("Appetizer")
            delay(1000L)
            emit("Main dish")
            delay(100L)
            emit("Dessert")
        }

        viewModelScope.launch {
            flow.onEach {
                println("FLOW: $it is delivered")
            }.buffer()
                .collect {
                    println("FLOW: Now eating $it")
                    delay(1500L)
                    println("FLOW: Finish eating $it")
                }
        }
    }

    private fun collectFlowWithConflate() {
        val flow = flow {
            delay(250L)
            emit("Appetizer")
            delay(1000L)
            emit("Main dish")
            delay(100L)
            emit("Dessert")
        }

        viewModelScope.launch {
            flow.onEach {
                println("FLOW: $it is delivered")
            }.conflate()
                .collect {
                    println("FLOW: Now eating $it")
                    delay(1500L)
                    println("FLOW: Finish eating $it")
                }
        }
    }
}
