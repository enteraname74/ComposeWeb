package view.composable.homecomposable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import view.utils.ColorUtils
import view.utils.Constants
import view.utils.HomeElementsPosition

@Composable
fun HomeScreenAppBar(
    listState: LazyListState
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = ColorUtils.primary)
            .height(64.dp)
            .padding(vertical = Constants.Size.small, horizontal = Constants.Size.medium),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Constants.Size.large)
        ) {
            HeaderElement(
                title = "Home",
                listState = listState,
                elementPosition = HomeElementsPosition.HOME
            )
            HeaderElement(
                title = "Technologies",
                listState = listState,
                elementPosition = HomeElementsPosition.TECHNOLOGIES
            )
            HeaderElement(
                title = "Projects",
                listState = listState,
                elementPosition = HomeElementsPosition.PROJECTS
            )
            HeaderElement(
                title = "About",
                listState = listState,
                elementPosition = HomeElementsPosition.ABOUT
            )
        }
    }
}

@Composable
private fun HeaderElement(
    title: String,
    elementPosition: Int,
    listState: LazyListState
) {
    val coroutineScope = rememberCoroutineScope()
    val isSelected = (listState.firstVisibleItemIndex == elementPosition) || (listState.firstVisibleItemIndex == elementPosition + 1)

    TextButton(
        onClick = {
            coroutineScope.launch { goToElement(listState, elementPosition) }
        }
    ) {
        Column(
            modifier = Modifier
        ) {
            Text(
                text = title,
                color = if (isSelected) ColorUtils.highlight else ColorUtils.onPrimary,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

/**
 * Tries to go to an element at a given index
 */
private suspend fun goToElement(
    listState: LazyListState,
    index: Int
) {
    if (index < listState.layoutInfo.totalItemsCount) {
        listState.animateScrollToItem(index)
    }
}