package com.mtjin.firebasemvvm.di

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.mtjin.firebasemvvm.data.source.remote.MainRemoteDataSource
import com.mtjin.firebasemvvm.data.source.remote.MainRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule {
    @Provides
    @Singleton
    fun provideMovieRemoteDataSource(database: DatabaseReference): MainRemoteDataSource {
        return MainRemoteDataSourceImpl(database)
    }

    @Provides
    @Singleton
    fun provideFireDatabase(): DatabaseReference {
        return Firebase.database.reference
    }
}