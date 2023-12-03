package view.composable.homecomposable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import view.utils.ColorUtils
import view.utils.Constants
import view.utils.HomeElementsPosition
import view.utils.LazyListUtils

@Composable
fun HomeDrawer(
    listState: LazyListState,
    drawerState: DrawerState
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(250.dp)
            .background(
                color = ColorUtils.primary,
                shape = RoundedCornerShape(
                    topEnd = 10.dp,
                    bottomEnd = 10.dp
                )
            )
            .padding(Constants.Size.small),
        verticalArrangement = Arrangement.spacedBy(Constants.Size.small)
    ) {
        DrawerElement(
            title = "Home",
            listState = listState,
            elementPosition = HomeElementsPosition.HOME,
            drawerState = drawerState,
            icon = Icons.Rounded.Home
        )
        DrawerElement(
            title = "Technologies",
            listState = listState,
            elementPosition = HomeElementsPosition.TECHNOLOGIES,
            drawerState = drawerState,
            icon = Icons.Rounded.Code
        )
        DrawerElement(
            title = "Projects",
            listState = listState,
            elementPosition = HomeElementsPosition.PROJECTS,
            drawerState = drawerState,
            icon = Icons.Rounded.Build
        )
        DrawerElement(
            title = "About",
            listState = listState,
            elementPosition = HomeElementsPosition.ABOUT,
            drawerState = drawerState,
            icon = Icons.Rounded.Info
        )
    }
}

@Composable
fun DrawerElement(
    title: String,
    icon: ImageVector,
    elementPosition: Int,
    listState: LazyListState,
    drawerState: DrawerState
) {
    val coroutineScope = rememberCoroutineScope()
    val isSelected =
        (listState.firstVisibleItemIndex == elementPosition) || (listState.firstVisibleItemIndex == elementPosition + 1)

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(Constants.Size.small)
    ) {
        Image(
            imageVector = icon,
            contentDescription = "",
            modifier = Modifier.size(Constants.ImageSize.medium),
            colorFilter = ColorFilter.tint(color = if (isSelected) ColorUtils.highlight else ColorUtils.onPrimary)
        )
        TextButton(
            onClick = {
                coroutineScope.launch {
                    LazyListUtils.goToElement(listState, elementPosition)
                    drawerState.close()
                }
            }
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