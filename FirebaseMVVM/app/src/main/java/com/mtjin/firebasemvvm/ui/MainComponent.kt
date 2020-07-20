package com.mtjin.firebasemvvm.ui

import dagger.Subcomponent


@Subcomponent
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainComponent
    }

    fun inject(mainActivity: MainActivity)
}