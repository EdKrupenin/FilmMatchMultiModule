package com.keo.source.home.home_impl.di

import com.keo.source.core.core_api.ApplicationComponentProvider
import com.keo.source.home.home_impl.HomeFeatureImpl
import dagger.Component

@Component(
    dependencies = [ApplicationComponentProvider::class],
    modules = [HomeFeatureModule::class]
)
interface HomeFeatureComponent {
    companion object{
        fun create(provider: ApplicationComponentProvider): HomeFeatureComponent {
            return DaggerHomeFeatureComponent.builder()
                .applicationComponentProvider(provider)
                .build()
        }
    }

    fun inject(homeFeatureImpl: HomeFeatureImpl)
}