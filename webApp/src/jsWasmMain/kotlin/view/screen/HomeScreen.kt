package view.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import model.Project
import view.composable.homecomposable.HomeScreenAppBar
import view.composable.homecomposable.HomeScreenList
import view.utils.ColorUtils

@Composable
fun HomeScreen(
    navigateToProjectScreen: (Project) -> Unit
) {
    val listState = rememberLazyListState()
    ColorUtils.currentShownElement = listState.firstVisibleItemIndex

    Scaffold(
        topBar = { HomeScreenAppBar(listState = listState) },
        containerColor = ColorUtils.primary,
    ) { padding ->

        HomeScreenList(
            listState = listState,
            modifier = Modifier
                .padding(padding),
            navigateToProjectScreen =  navigateToProjectScreen
        )
    }
}