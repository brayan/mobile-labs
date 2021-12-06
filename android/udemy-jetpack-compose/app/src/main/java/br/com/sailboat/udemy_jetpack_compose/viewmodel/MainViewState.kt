package br.com.sailboat.udemy_jetpack_compose.viewmodel

import androidx.lifecycle.MutableLiveData
import br.com.sailboat.udemy_jetpack_compose.UserProfile

class MainViewState {

    val name = MutableLiveData("")
    val users = MutableLiveData<List<UserProfile>>()

}