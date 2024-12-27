package com.keo.source.core.core_impl

import com.keo.source.core.core_api.CoroutineDispatchersProvider
import com.keo.source.core.core_api.DefaultDispatcher
import com.keo.source.core.core_api.IODispatcher
import com.keo.source.core.core_api.MainDispatcher
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
object CoroutineDispatchersModule {
    @DefaultDispatcher
    @Provides
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @IODispatcher
    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @MainDispatcher
    @Provides
    fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

//    @Singleton
//    @Binds
//    fun bindCoroutineDispatchersProvider(impl: CoroutineDispatchersProviderImp): CoroutineDispatchersProvider
}
