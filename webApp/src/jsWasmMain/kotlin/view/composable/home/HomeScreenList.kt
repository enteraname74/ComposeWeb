package view.composable.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.Project
import view.composable.home.parts.HomeAbout
import view.composable.home.parts.HomeInformation
import view.composable.home.parts.HomeProjects
import view.composable.home.parts.HomeTechnologies
import view.utils.ColorUtils
import view.utils.Constants

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreenList(
    listState: LazyListState,
    modifier: Modifier = Modifier,
    navigateToProjectScreen: (Project) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        state = listState,
        contentPadding = PaddingValues(horizontal = Constants.Size.extraLarge2),
        verticalArrangement = Arrangement.spacedBy(Constants.Size.medium)
    ) {

        stickyHeader  {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = ColorUtils.primary)
            ) {
                Text(
                    text = "Home",
                    fontSize = Constants.TextSize.title,
                    color = ColorUtils.onPrimary
                )
            }
        }
        item {
            HomeInformation()
        }
        stickyHeader  {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Constants.Size.extraLarge)
                    .background(color = ColorUtils.primary)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    horizontalArrangement = Arrangement.spacedBy(Constants.Size.small),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Technologies",
                        fontSize = Constants.TextSize.title,
                        color = ColorUtils.onPrimary
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        horizontalAlignment = Alignment.End,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Spacer(
                            modifier = Modifier
                                .height(5.dp)
                                .fillMaxWidth(0.8f)
                                .background(
                                    color = ColorUtils.secondary,
                                    shape = RoundedCornerShape(50)
                                )
                        )
                        Spacer(
                            modifier = Modifier
                                .height(5.dp)
                                .fillMaxWidth(0.6f)
                                .background(
                                    color = ColorUtils.secondary,
                                    shape = RoundedCornerShape(50)
                                )
                        )
                    }
                }
            }
        }
        item {
            HomeTechnologies()
        }
        stickyHeader  {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = ColorUtils.primary)
            ) {
                Text(
                    text = "Projects",
                    fontSize = Constants.TextSize.title,
                    color = ColorUtils.onPrimary
                )
            }
        }
        item {
            HomeProjects(
                navigateToProjectScreen = navigateToProjectScreen
            )
        }
        stickyHeader  {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = ColorUtils.primary)
            ) {
                Text(
                    text = "About",
                    fontSize = Constants.TextSize.title,
                    color = ColorUtils.onPrimary
                )
            }
        }
        item {
           HomeAbout()
        }
    }
}