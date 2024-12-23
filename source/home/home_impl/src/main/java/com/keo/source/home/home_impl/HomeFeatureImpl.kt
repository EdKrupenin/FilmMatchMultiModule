package com.keo.source.home.home_impl

import android.util.Log
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.keo.source.home.home_api.HomeFeatureApi
import javax.inject.Inject

//private const val baseRoute = "home"
//private const val scenarioABRoute = "$baseRoute/scenario"
//private const val screenBRoute = "$scenarioABRoute/B"
//private const val screenARoute = "$scenarioABRoute/A"
//private const val argumentKey = "arg"

class HomeFeatureImpl @Inject constructor() : HomeFeatureApi {
    override fun baseRoute(): String = "home_screen"

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        Log.d("HomeFeatureImpl", "Registering route: ${baseRoute()}")
        navGraphBuilder.composable(baseRoute()) {
            HomeScreen(onNavigateToABFlow = {
                navController.navigate("scenarioABRoute")
            }, modifier = modifier)
        }
    }
}