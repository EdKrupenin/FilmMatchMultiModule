package com.keo.source.base

import android.util.Log
import com.keo.source.base.dto.Genre
import com.keo.source.core.core_api.Cache
import com.keo.source.core.core_api.IODispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SwipeRepositoryImpl @Inject constructor(
    @IODispatcher private val io: CoroutineDispatcher,
    private val cache: Cache<DataType, List<@JvmSuppressWildcards Any>>,
    private val retrofit: NetworkApi
) : GenreRepository {
    override suspend fun getGenres(): List<Genre> = withContext(io) {
        cache.get(DataType.GenreType)?.filterIsInstance<Genre>()
            ?: fetchGenresFromNetwork().also {
                cache.put(DataType.GenreType, it)
            }
    }

    private suspend fun fetchGenresFromNetwork(): List<Genre> {
        return try {
            retrofit.getGenres()
        } catch (e: Exception) {
            Log.e("SwipeRepository", "Error fetching genres", e)
            emptyList()
        }
    }
}