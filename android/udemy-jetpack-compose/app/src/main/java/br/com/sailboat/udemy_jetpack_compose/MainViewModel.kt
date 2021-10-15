package br.com.sailboat.udemy_jetpack_compose

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val viewState = MainViewState()

    fun dispatchViewAction(viewAction: MainViewAction) {
        when (viewAction) {
            is MainViewAction.OnInsertName -> onInsertName(viewAction.name)
        }
    }

    private fun onInsertName(name: String) {
        viewState.name.value = name
    }

}