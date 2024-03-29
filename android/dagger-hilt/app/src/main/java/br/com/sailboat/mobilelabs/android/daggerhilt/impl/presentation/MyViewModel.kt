package br.com.sailboat.mobilelabs.android.daggerhilt.impl.presentation

import androidx.lifecycle.ViewModel
import br.com.sailboat.mobilelabs.android.daggerhilt.domain.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: MyRepository
) : ViewModel() {

}