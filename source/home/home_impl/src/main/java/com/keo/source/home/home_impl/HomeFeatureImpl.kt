package com.keo.source.home.home_impl

import android.app.Application
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.keo.genres_api.GenresFeatureApi
import com.keo.source.core.core_api.AppProvider
import com.keo.source.core.core_api.AppWithApplicationComponent
import com.keo.source.home.home_api.HomeFeatureApi
import com.keo.source.home.home_impl.di.HomeFeatureComponent.Companion.create
import javax.inject.Inject

class HomeFeatureImpl @Inject constructor(
    appProvider: AppProvider
) : HomeFeatureApi {
    @Inject
    lateinit var routeToGenres: GenresFeatureApi

    init {
        val application = appProvider.provideContext() as Application
        val applicationComponentProvider =
            (application as AppWithApplicationComponent).getApplicationComponentProvider()
        create(applicationComponentProvider).inject(this)
    }

    override fun baseRoute(): String = "home_screen"

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(baseRoute()) {
            HomeScreen(onNavigateToGenres = {
                navController.navigate(routeToGenres.baseRoute())
            }, modifier = modifier)
        }
    }
}