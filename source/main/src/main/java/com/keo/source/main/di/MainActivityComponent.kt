package com.keo.source.main.di

import com.keo.source.core.core_api.ApplicationComponentProvider
import com.keo.source.main.MainActivity
import dagger.Component

@Component(
    dependencies = [ApplicationComponentProvider::class],
    modules = [MainActivityModule::class]
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