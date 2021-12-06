package br.com.sailboat.udemy_jetpack_compose.viewmodel

sealed class MainViewAction {
    data class OnInsertName(val name: String) : MainViewAction()
    object OnStartMainProfile : MainViewAction()
}