package br.com.sailboat.udemy_jetpack_compose

sealed class MainViewAction {
    data class OnInsertName(val name: String) : MainViewAction()
}