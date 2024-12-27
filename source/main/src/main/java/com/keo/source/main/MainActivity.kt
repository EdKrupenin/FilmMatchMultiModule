package com.keo.source.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.keo.source.base.di.BaseComponent
import com.keo.source.core.core_api.AppWithApplicationComponent
import com.keo.source.core.core_api.FeatureApi
import com.keo.source.core.core_api.FeatureApiMap
import com.keo.source.core.core_api.findRoute
import com.keo.source.core.core_api.register
import com.keo.source.home.home_api.HomeFeatureApi
import com.keo.source.main.di.MainActivityComponent
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    @Inject
    lateinit var featureApis: FeatureApiMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appWithApplicationComponent =
            (application as AppWithApplicationComponent).getApplicationComponentProvider()

        MainActivityComponent.create(appWithApplicationComponent).inject(this)
        BaseComponent.create(appWithApplicationComponent)

        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val startDestination = featureApis.findRoute<HomeFeatureApi>()?.baseRoute()
            requireNotNull(startDestination) { "Start destination cannot be null!" }
            NavHost(
                navController = navController, startDestination = startDestination
            ) {
                Log.d("MainActivity", "Registering route size: ${featureApis.keys.size}")
                featureApis.values.forEach { provider ->
                    val featureApi = provider.get() as? FeatureApi
                    if (featureApi != null) {
                        Log.d("MainActivity", "Registering route: ${featureApi.baseRoute()}")
                        register(
                            featureApi = featureApi,
                            navController = navController,
                            modifier = Modifier.padding(16.dp)
                        )
                    } else {
                        Log.w("MainActivity", "Skipping non-FeatureApi object")
                    }
                }
            }
        }
    }
}