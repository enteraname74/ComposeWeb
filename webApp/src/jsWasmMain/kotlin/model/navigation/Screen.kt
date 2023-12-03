package model.navigation

import androidx.compose.runtime.Composable

/**
 * A Screen to be shown.
 */
data class Screen<T>(
    val screenRoute: Route<T>,
    val screen: @Composable () -> Unit
)