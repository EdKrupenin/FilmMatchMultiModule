package com.keo.source.core.core_api

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import dagger.internal.Provider

fun NavGraphBuilder.register(
    featureApi: FeatureApi,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    featureApi.registerGraph(
        navGraphBuilder = this,
        navController = navController,
        modifier = modifier
    )
}

inline fun <reified T> Map<Class<*>, Provider<Any>>.findRoute(): T? {
    val provider = this[T::class.java] ?: return null
    return provider.get() as? T
}