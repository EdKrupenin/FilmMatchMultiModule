package com.keo.source.core.core_api

import javax.inject.Qualifier
import javax.inject.Scope

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IODispatcher

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DefaultDispatcher

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MainDispatcher

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope