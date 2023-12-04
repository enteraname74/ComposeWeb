package view.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalWindowInfo
import model.Project
import view.composable.home.HomeDrawer
import view.composable.home.HomeScreenAppBar
import view.composable.home.HomeScreenList
import view.utils.ColorUtils

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HomeScreen(
    navigateToProjectScreen: (Project) -> Unit,
    listState: LazyListState
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val isMinimised = LocalWindowInfo.current.containerSize.width <= 600
    ColorUtils.currentShownElement = listState.firstVisibleItemIndex

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = isMinimised,
        drawerContent = {
            HomeDrawer(
                listState = listState,
                drawerState = drawerState
            )
        },
        content = {
            Scaffold(
                topBar = {
                    HomeScreenAppBar(
                        listState = listState,
                        drawerState = drawerState,
                        shouldBeMinimised = isMinimised
                    )
                },
                containerColor = ColorUtils.primary,
            ) { padding ->
                HomeScreenList(
                    listState = listState,
                    modifier = Modifier
                        .padding(padding),
                    navigateToProjectScreen = navigateToProjectScreen
                )
            }
        }
    )
}