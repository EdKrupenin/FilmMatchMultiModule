package com.keo.source.base.di

import com.keo.source.base.DataType
import com.keo.source.base.GenreRepository
import com.keo.source.base.NetworkApi
import com.keo.source.base.SwipeCacheImpl
import com.keo.source.base.SwipeRepositoryImpl
import com.keo.source.core.core_api.Cache
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
interface BaseModule {
    companion object {
        @Provides
        fun provideNetworkApi(retrofit: Retrofit): NetworkApi =
            retrofit.create(NetworkApi::class.java)
    }
    @Binds
    fun bindSwipeCache(impl: SwipeCacheImpl): Cache<DataType, List<Any>>
    @Binds
    fun bindGenreRepository(impl: SwipeRepositoryImpl): GenreRepository
}