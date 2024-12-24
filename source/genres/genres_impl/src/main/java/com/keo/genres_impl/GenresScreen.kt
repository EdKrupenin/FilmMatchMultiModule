package com.keo.genres_impl

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.keo.source.ui_kit.atom.FiledButton


@Composable
internal fun GenresScreen(
    modifier: Modifier,
    onNavigateToABFlow: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        FiledButton(
            text = "Genres",
            onClick = onNavigateToABFlow,
            modifier = Modifier.padding(16.dp),
        )
    }
}