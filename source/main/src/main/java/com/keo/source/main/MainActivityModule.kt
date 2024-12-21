package com.keo.source.main

import com.keo.source.core.core_api.AppWithApplicationComponent
import com.keo.source.core.core_api.FeatureApi
import dagger.Module
import dagger.Provides

@Module
interface MainActivityModule {
    companion object{
        @Provides
        fun provideFeatureApis(appComponent: AppWithApplicationComponent): Set<FeatureApi> {
            return appComponent.getApplicationComponentProvider().featureApis()
        }
    }
}