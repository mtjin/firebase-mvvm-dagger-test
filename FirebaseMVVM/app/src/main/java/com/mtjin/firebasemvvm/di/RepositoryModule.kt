package com.mtjin.firebasemvvm.di

import com.mtjin.firebasemvvm.data.source.MainRepository
import com.mtjin.firebasemvvm.data.source.MainRepositoryImpl
import com.mtjin.firebasemvvm.data.source.local.MainLocalDataSource
import com.mtjin.firebasemvvm.data.source.remote.MainRemoteDataSource
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun provideMovieRepository(
        mainRemoteDataSource: MainRemoteDataSource,
        mainLocalDataSource: MainLocalDataSource
    ): MainRepository {
        return MainRepositoryImpl(mainRemoteDataSource, mainLocalDataSource)
    }
}
