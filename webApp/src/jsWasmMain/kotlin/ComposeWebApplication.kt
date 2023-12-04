import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import model.Project
import model.navigation.NavigationController
import model.navigation.Route
import model.navigation.RoutesNames
import model.navigation.Screen
import view.composable.NavigationHost
import view.screen.HomeScreen
import view.screen.ProjectScreen

@Composable
internal fun ComposeWebApplication() {
    val listState = rememberLazyListState()
    val navController = rememberSaveable {
        NavigationController(
            initialRoute = Route(
                route = RoutesNames.HOME_PAGE
            )
        )
    }

    ComposeWebTheme {
        NavigationHost(
            navigationController = navController,
            screens = arrayListOf(
                Screen(
                    screenRoute = RoutesNames.HOME_PAGE,
                    screen = {
                        HomeScreen(
                            navigateToProjectScreen = {
                                navController.navigateTo(
                                    route = Route(
                                        route = RoutesNames.PROJECT_PAGE,
                                        arguments = mapOf("project" to it)
                                    )
                                )
                            },
                            listState = listState
                        )
                    }
                ),
                Screen(
                    screenRoute = RoutesNames.PROJECT_PAGE,
                    screen = {
                        ProjectScreen(
                            navigateBack = navController::navigateBack,
                            project = (navController.currentRoute.arguments["project"] as Project?) ?: Project()
                        )
                    }
                )
            )
        )
    }
}
