package br.com.sailboat.mobilelabs.android.daggerhilt.impl.data.repository

import br.com.sailboat.mobilelabs.android.daggerhilt.impl.data.datasource.remote.MyApi
import br.com.sailboat.mobilelabs.android.daggerhilt.domain.repository.MyRepository
import javax.inject.Inject

class MyRepositoryImpl @Inject constructor(
    private val api: MyApi,
) : MyRepository {

    override suspend fun doNetworkCall() {
        api.doNetworkCall()
    }
}
