package br.com.sailboat.udemy_jetpack_compose.viewmodel

import androidx.lifecycle.ViewModel
import br.com.sailboat.udemy_jetpack_compose.R
import br.com.sailboat.udemy_jetpack_compose.UserProfile

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
        val users = listOf(
            UserProfile(
                name = "John Doe",
                status = true,
                drawableId = R.drawable.profile_picture_sample,
            ),
            UserProfile(
                name = "John Doe 2",
                status = false,
                drawableId = R.drawable.profile_picture_sample,
            )
        )
        viewState.users.value = users
    }

}