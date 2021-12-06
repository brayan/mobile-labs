package br.com.sailboat.udemy_jetpack_compose.viewmodel

import androidx.lifecycle.ViewModel
import br.com.sailboat.udemy_jetpack_compose.R
import br.com.sailboat.udemy_jetpack_compose.UserProfile
import br.com.sailboat.udemy_jetpack_compose.UserProfileFactory

class MainViewModel : ViewModel() {

    val viewState = MainViewState()

    fun dispatchViewAction(viewAction: MainViewAction) {
        when (viewAction) {
            is MainViewAction.OnInsertName -> onInsertName(viewAction.name)
            is MainViewAction.OnStartMainProfile -> onStartMainProfile()
        }
    }

    private fun onInsertName(name: String) {
        viewState.name.value = name
    }

    private fun onStartMainProfile() {
        viewState.users.value = UserProfileFactory.makeList()
    }

}