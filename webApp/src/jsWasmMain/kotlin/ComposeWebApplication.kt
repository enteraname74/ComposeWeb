import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import view.composable.NavigationHost
import model.navigation.NavigationController
import model.navigation.Route
import model.navigation.RoutesNames
import model.navigation.Screen
import view.screen.HomeScreen
import view.screen.TestScreen

@Composable
internal fun ComposeWebApplication() {
    val navController = rememberSaveable {
        NavigationController(
            initialRoute = RoutesNames.HOME_PAGE
        )
    }

    ComposeWebTheme {
        NavigationHost(
            navigationController = navController,
            screens = arrayListOf(
                Screen(
                    screenRoute = Route(
                        route = RoutesNames.HOME_PAGE
                    ),
                    screen = {
                        HomeScreen(
                            navigateToTestScreen = { navController.navigateTo(RoutesNames.TEST_PAGE) }
                        )
                    }
                ),
                Screen(
                    screenRoute = Route(
                        route = RoutesNames.TEST_PAGE
                    ),
                    screen = {
                        TestScreen(
                            navigateBack = { navController.navigateBack() }
                        )
                    }
                )
            )
        )
    }
}
