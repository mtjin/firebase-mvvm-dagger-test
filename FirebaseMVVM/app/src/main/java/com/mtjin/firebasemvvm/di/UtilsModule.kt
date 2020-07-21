package com.mtjin.firebasemvvm.di

import android.content.Context
import com.mtjin.firebasemvvm.utils.NetworkManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UtilsModule {
    @Provides
    @Singleton
    fun provideNetworkManager(context: Context): NetworkManager {
        return NetworkManager(context)
    }
}