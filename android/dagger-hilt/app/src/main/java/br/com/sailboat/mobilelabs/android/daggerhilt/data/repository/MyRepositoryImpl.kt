package br.com.sailboat.mobilelabs.android.daggerhilt.data.repository

import br.com.sailboat.mobilelabs.android.daggerhilt.data.remote.MyApi
import br.com.sailboat.mobilelabs.android.daggerhilt.domain.repository.MyRepository
import javax.inject.Inject

class MyRepositoryImpl @Inject constructor(
    private val api: MyApi,
) : MyRepository {

    override suspend fun doNetworkCall() {
        api.doNetworkCall()
    }
}
