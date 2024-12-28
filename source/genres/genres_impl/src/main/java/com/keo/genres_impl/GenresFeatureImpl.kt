package com.keo.genres_impl

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.keo.genres_api.GenresFeatureApi
import com.keo.genres_impl.di.GenresFeatureComponent
import com.keo.source.base.di.BaseComponentProvider
import com.keo.source.core.core_api.AppProvider
import javax.inject.Inject

class GenresFeatureImpl @Inject constructor(
    appProvider: AppProvider
) : GenresFeatureApi {

    private var viewModel: GenresFeatureVM

    init {
        val context = appProvider.provideContext()
        val baseComponent = (context as? BaseComponentProvider)?.provideBaseComponent()
            ?: throw IllegalStateException("Context does not implement BaseComponentProvider")
        val featureComponent = GenresFeatureComponent.create(baseComponent).also { it.inject(this) }

        viewModel = featureComponent.viewModelFactory().create()
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
            }, modifier = modifier, viewModel = viewModel)
        }
    }
}