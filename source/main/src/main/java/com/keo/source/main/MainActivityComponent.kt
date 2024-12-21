package com.keo.source.main

import com.keo.source.core.core_api.ApplicationComponentProvider
import dagger.Component

@Component(
    dependencies = [ApplicationComponentProvider::class],
)
interface MainActivityComponent {
    companion object {
        fun create(provider: ApplicationComponentProvider): MainActivityComponent {
            return DaggerMainActivityComponent.builder()
                .applicationComponentProvider(provider)
                .build()
        }
    }

    fun inject(mainActivity: MainActivity)
}