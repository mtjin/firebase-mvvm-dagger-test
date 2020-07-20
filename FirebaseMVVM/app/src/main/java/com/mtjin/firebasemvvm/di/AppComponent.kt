package com.mtjin.firebasemvvm.di

import android.content.Context
import com.mtjin.firebasemvvm.ui.MainComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ViewModelModule::class, ViewModelFactoryModule::class, AppSubComponentsModule::class, RepositoryModule::class, RemoteDataModule::class]
)
interface AppComponent {
    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun mainComponent(): MainComponent.Factory

//    fun loginLocalDataSource(): LoginLocalDataSourceImpl
//
//    fun movieLocalDataSource(): MovieLocalDataSourceImpl
//
//    fun movieRemoteDataSource(): MovieRemoteDataSourceImpl
//
//    fun networkManager(): NetworkManager
//
//    fun apiInterface(): ApiInterface
}