package br.com.alura.technews.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel() {

    val progress = MutableLiveData<Boolean>()


    open fun start() {

    }

}