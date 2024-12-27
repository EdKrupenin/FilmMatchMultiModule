package com.keo.source.ui_kit.atom

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun Chip(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    var selected by remember { mutableStateOf(false) }

    FilterChip(
        onClick = { if (enabled)  { selected = !selected } },
        label = {
            Text(text)
        },
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        },
        enabled = enabled,
        colors = if (enabled) { // Conditional colors for enabled/disabled
            FilterChipDefaults.filterChipColors()
        } else {
            FilterChipDefaults.filterChipColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant, // Or your desired disabled color
                labelColor = MaterialTheme.colorScheme.onSurfaceVariant, // Or your desired disabled color
                iconColor = MaterialTheme.colorScheme.onSurfaceVariant // Or your desired disabled color
            )
        },
        modifier = modifier
    )
}