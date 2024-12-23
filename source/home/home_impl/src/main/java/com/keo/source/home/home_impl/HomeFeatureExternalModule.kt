package com.keo.source.home.home_impl

import com.keo.source.home.home_api.HomeFeatureApi
import dagger.Module
import dagger.Provides
import dagger.internal.Provider
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap


@Module
interface HomeFeatureExternalModule {
    companion object{
        @Provides
        @IntoMap
        @ClassKey(HomeFeatureApi::class)
        fun provideHomeFeatureApi(): Provider<Any> = Provider { HomeFeatureImpl() }
//                //Provider<FeatureApi> = Provider { HomeFeatureImpl() }
//                //Any = HomeFeatureImpl()
//                //Provider<Any> = Provider { HomeFeatureImpl() }
    }
//    @Binds
//    @IntoMap
//    @ClassKey(HomeFeatureApi::class)
//    fun bindHomeFeatureApi(featureApi: HomeFeatureImpl): Provider<Any>
}