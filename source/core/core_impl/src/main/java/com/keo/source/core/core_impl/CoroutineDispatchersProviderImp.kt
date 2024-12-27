package com.keo.source.core.core_impl

import com.keo.source.core.core_api.CoroutineDispatchersProvider
import com.keo.source.core.core_api.DefaultDispatcher
import com.keo.source.core.core_api.IODispatcher
import com.keo.source.core.core_api.MainDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

//class CoroutineDispatchersProviderImp @Inject constructor() : CoroutineDispatchersProvider {
//    @IODispatcher
//    override fun getIO() = Dispatchers.IO
//
//    @DefaultDispatcher
//    override fun getDefault() = Dispatchers.Default
//
//    @MainDispatcher
//    override fun getMain() = Dispatchers.Main
//}
