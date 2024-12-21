package com.keo.source.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.keo.source.core.core_api.AppWithApplicationComponent
import com.keo.source.core.core_api.FeatureApi
import com.keo.source.ui_kit.theme.FilmMatchTheme

class MainActivity : ComponentActivity() {
    private lateinit var featureApis: Set<FeatureApi>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appWithApplicationComponent =
            (application as AppWithApplicationComponent).getApplicationComponentProvider()

        MainActivityComponent.create(appWithApplicationComponent)
            .inject(this)

        featureApis = appWithApplicationComponent.featureApis()


        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "home_screen"
            ) {
                featureApis.forEach { featureApi ->
                    featureApi.registerGraph(this, navController, Modifier.padding(16.dp))
                }
            }
        }
    }
}