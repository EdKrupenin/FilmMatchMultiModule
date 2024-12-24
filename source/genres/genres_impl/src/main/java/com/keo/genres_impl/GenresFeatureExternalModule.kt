package com.keo.genres_impl

import com.keo.genres_api.GenresFeatureApi
import com.keo.source.core.core_api.AppProvider
import dagger.Module
import dagger.Provides
import dagger.internal.Provider
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
object GenresFeatureExternalModule {
    @Provides
    @IntoMap
    @ClassKey(GenresFeatureApi::class)
    fun provideGenresFeatureApi(application: AppProvider): Provider<Any> =
        Provider { GenresFeatureImpl(application) }
}