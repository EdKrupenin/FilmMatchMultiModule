package com.keo.source.home.home_impl

import com.keo.source.core.core_api.FeatureApi
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet

@Module
interface HomeFeatureExternalModule {
    companion object{
        @Provides
        @IntoSet
        fun provideFeatureApi(): FeatureApi = HomeFeatureImpl()
    }
}