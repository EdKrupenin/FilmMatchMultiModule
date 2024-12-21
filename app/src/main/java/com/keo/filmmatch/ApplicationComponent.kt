package com.keo.filmmatch

import android.app.Application
import com.keo.source.core.core_api.AppProvider
import com.keo.source.core.core_api.ApplicationComponentProvider
import com.keo.source.core.core_api.NetworkProvider
import com.keo.source.core.core_factory.CoreProviderFactory
import dagger.Component

@Component(
    dependencies = [AppProvider::class, NetworkProvider::class]
)
interface ApplicationComponent : ApplicationComponentProvider {
    companion object {
        fun init(application: Application) : ApplicationComponent =
            DaggerApplicationComponent.builder()
                .appProvider(ApplicationContextComponent.create(application))
                .networkProvider(CoreProviderFactory.createNetworkBuilder())
                .build()
    }
}