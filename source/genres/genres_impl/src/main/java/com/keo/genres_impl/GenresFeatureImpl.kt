package com.keo.genres_impl

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.keo.genres_api.GenresFeatureApi
import com.keo.source.core.core_api.AppProvider
import javax.inject.Inject

class GenresFeatureImpl @Inject constructor(
    appProvider: AppProvider
) : GenresFeatureApi {

    init {

    }

    override fun baseRoute(): String = "genres_screen"

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(baseRoute()) {
            GenresScreen(onNavigateToABFlow = {
                navController.navigate("scenarioABRoute")
            }, modifier = modifier)
        }
    }
}