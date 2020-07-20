package com.mtjin.firebasemvvm.di

import androidx.lifecycle.ViewModel
import com.mtjin.firebasemvvm.ui.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(movieSearchViewModel: MainViewModel): ViewModel
}