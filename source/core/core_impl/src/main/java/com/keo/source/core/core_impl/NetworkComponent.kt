package com.keo.source.core.core_impl

import com.keo.source.core.core_api.NetworkProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (
    modules = [NetworkModule::class]
)
interface NetworkComponent : NetworkProvider