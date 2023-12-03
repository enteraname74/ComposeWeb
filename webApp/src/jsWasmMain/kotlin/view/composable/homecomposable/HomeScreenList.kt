package view.composable.homecomposable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import view.utils.Constants

@Composable
fun HomeScreenList(
    listState: LazyListState,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        state = listState,
        contentPadding = PaddingValues(Constants.Padding.large)
    ) {
        item {
            HomeInformation()
        }
        item {
            HomeDescription()
        }
        item {
            HomeTechnologies()
        }
        item {
            HomeProjects()
        }
        item {
            HomeAbout()
        }
    }
}