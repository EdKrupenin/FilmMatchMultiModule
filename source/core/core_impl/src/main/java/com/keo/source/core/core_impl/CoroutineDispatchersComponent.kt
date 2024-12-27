package com.keo.source.core.core_impl

import com.keo.source.core.core_api.CoroutineDispatchersProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [CoroutineDispatchersModule::class]
)
interface CoroutineDispatchersComponent : CoroutineDispatchersProvider