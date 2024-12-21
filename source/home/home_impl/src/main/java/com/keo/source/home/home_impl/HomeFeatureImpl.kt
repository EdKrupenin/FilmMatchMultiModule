package com.keo.source.home.home_impl

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.keo.source.home.home_api.HomeFeatureApi
import javax.inject.Inject

private const val baseRoute = "home"
private const val scenarioABRoute = "$baseRoute/scenario"
private const val screenBRoute = "$scenarioABRoute/B"
private const val screenARoute = "$scenarioABRoute/A"
private const val argumentKey = "arg"

class HomeFeatureImpl @Inject constructor() : HomeFeatureApi {
    override fun homeRoute(): String = "home_screen"

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(homeRoute()) {
            HomeScreen(onNavigateToABFlow = {
                navController.navigate(scenarioABRoute)
            }, modifier = modifier)
        }
    }
}