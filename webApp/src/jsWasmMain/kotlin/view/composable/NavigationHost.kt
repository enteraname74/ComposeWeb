package view.composable

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import model.navigation.NavigationController
import model.navigation.Screen

/**
 * Navigation host used to show the current screen.
 * If a screen isn't found by the navigationController, the first screen is shown.
 * If no screens are given, a default view is shown.
 */
@Composable
fun <T> NavigationHost(
    navigationController: NavigationController<T>,
    screens: List<Screen<T>>
) {
    Crossfade(targetState = navigationController.currentRoute) { currentRoute ->
        if (screens.isEmpty()) {
            DefaultNavigationView()
        } else {
            val screen = (screens.find { it.screenRoute.route == currentRoute } ?: screens.first()).screen
            screen()
        }
    }
}

/**
 * Default navigation view, used if no screens are given to the navigation host.
 */
@Composable
private fun DefaultNavigationView() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("No defined routes !")
    }
}