package com.keo.source.home.home_impl.di

import com.keo.genres_api.GenresFeatureApi
import com.keo.source.core.core_api.FeatureApiMap
import com.keo.source.core.core_api.findRoute
import dagger.Module
import dagger.Provides

@Module
interface HomeFeatureModule {
    companion object {
        @Provides
        fun provideHomeToGenresRoute(featureApiMap: FeatureApiMap): GenresFeatureApi {
            return featureApiMap.findRoute<GenresFeatureApi>()
                ?: throw IllegalStateException("GenresFeatureApi not found in FeatureApiMap")
        }
    }
}