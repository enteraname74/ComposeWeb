package view.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import view.composable.homecomposable.HomeScreenAppBar
import view.composable.homecomposable.HomeScreenList
import view.utils.ColorUtils
import view.utils.Constants

@Composable
fun HomeScreen(
    navigateToTestScreen: () -> Unit
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
                .padding(padding)
                .padding(horizontal = Constants.Size.extraLarge)
        )
    }
}