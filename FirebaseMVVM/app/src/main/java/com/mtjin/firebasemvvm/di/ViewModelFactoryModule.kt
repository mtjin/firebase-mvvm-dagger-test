package com.mtjin.firebasemvvm.di

import androidx.lifecycle.ViewModelProvider
import com.mtjin.firebasemvvm.utils.NetworkManager
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory) : ViewModelProvider.Factory
}
