package com.keo.filmmatch

import android.app.Application
import com.keo.genres_impl.GenresFeatureExternalModule
import com.keo.source.core.core_api.AppProvider
import com.keo.source.core.core_api.ApplicationComponentProvider
import com.keo.source.core.core_api.CoroutineDispatchersProvider
import com.keo.source.core.core_api.NetworkProvider
import com.keo.source.core.core_factory.CoreProviderFactory
import com.keo.source.home.home_impl.HomeFeatureExternalModule
import dagger.Component

@Component(
    dependencies = [AppProvider::class, NetworkProvider::class, CoroutineDispatchersProvider::class],
    modules = [HomeFeatureExternalModule::class, GenresFeatureExternalModule::class]
)
interface ApplicationComponent : ApplicationComponentProvider {
    companion object {
        fun init(application: Application) : ApplicationComponent =
            DaggerApplicationComponent.builder()
                .appProvider(ApplicationContextComponent.create(application))
                .networkProvider(CoreProviderFactory.createNetworkBuilder())
                .coroutineDispatchersProvider(CoreProviderFactory.createCoroutineBuilder())
                .build()
    }
}