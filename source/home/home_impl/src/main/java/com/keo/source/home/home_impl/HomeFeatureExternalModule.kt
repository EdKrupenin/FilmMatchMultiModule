package com.keo.source.home.home_impl

import com.keo.source.core.core_api.AppProvider
import com.keo.source.home.home_api.HomeFeatureApi
import dagger.Module
import dagger.Provides
import dagger.internal.Provider
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap


@Module
object HomeFeatureExternalModule {
    @Provides
    @IntoMap
    @ClassKey(HomeFeatureApi::class)
    fun provideHomeFeatureApi(application: AppProvider): Provider<Any> =
        Provider { HomeFeatureImpl(application) }
//                //Provider<FeatureApi> = Provider { HomeFeatureImpl() }
//                //Any = HomeFeatureImpl()
//                //Provider<Any> = Provider { HomeFeatureImpl() }
    // }
//    @Binds
//    @IntoMap
//    @ClassKey(HomeFeatureApi::class)
//    fun bindHomeFeatureApi(featureApi: HomeFeatureImpl): Provider<Any>
}