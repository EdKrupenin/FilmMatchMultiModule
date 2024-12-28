package com.keo.genres_impl

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.keo.source.ui_kit.atom.FiledButton


@Composable
internal fun GenresScreen(
    modifier: Modifier,
    onNavigateToABFlow: () -> Unit,
    viewModel: GenresFeatureVM
) {

    val state by viewModel.state.collectAsState()

//    when (state) {
//        is UiState.Loading -> {
//            CircularProgressIndicator(modifier = modifier)
//        }
//        is UiState.Success -> {
//            val genres = (state as UiState.Success<List<Genre>>).data
//            LazyColumn(modifier = modifier) {
//                items(genres) { genre ->
//                    Text(text = genre.name)
//                }
//            }
//        }
//        is UiState.Error -> {
//            val message = (state as UiState.Error).message
//            Text(text = "Error: $message", color = Color.Red)
//        }
//    }

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