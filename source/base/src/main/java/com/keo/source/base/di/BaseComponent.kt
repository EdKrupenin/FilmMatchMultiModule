package com.keo.source.base.di

import com.keo.source.core.core_api.ApplicationComponentProvider
import dagger.Component

@Component(
    modules = [BaseModule::class],
    dependencies = [ApplicationComponentProvider::class]
)
interface BaseComponent : GenreRepositoryProvider {
    companion object {
        fun create(provider: ApplicationComponentProvider): BaseComponent {
            return DaggerBaseComponent.builder()
                .applicationComponentProvider(provider)
                .build()
        }
    }
}
