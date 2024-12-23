package com.keo.source.home.home_impl

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.keo.source.ui_kit.atom.FiledButton

@Composable
internal fun HomeScreen(
    modifier: Modifier,
    onNavigateToABFlow: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            "Home",
            modifier = Modifier.padding(36.dp),
            fontSize = 24.sp
        )

        FiledButton(
            text = stringResource(R.string.swipeFeatureButton),
            onClick = onNavigateToABFlow,
            modifier = Modifier.padding(16.dp),
        )
    }
}