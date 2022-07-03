package br.com.sailboat.mobilelabs.android.daggerhilt.impl.di

import br.com.sailboat.mobilelabs.android.daggerhilt.impl.data.repository.MyRepositoryImpl
import br.com.sailboat.mobilelabs.android.daggerhilt.impl.domain.repository.MyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindMyRepository(myRepositoryImpl: MyRepositoryImpl): MyRepository
}
