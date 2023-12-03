package view.composable.homecomposable.parts

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.Project
import view.composable.ProjectCard
import view.utils.ColorUtils
import view.utils.Constants

@Composable
fun HomeProjects(
    navigateToProjectScreen: (Project) -> Unit
) {
    HomeElement {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopStart),
                verticalArrangement = Arrangement.spacedBy(Constants.Size.medium)
            ) {
                Text(
                    text = HomeProjectsText.CURRENTLY,
                    color = ColorUtils.onPrimary,
                    fontSize = Constants.TextSize.body2
                )
                LazyVerticalGrid(
                    columns = GridCells.FixedSize(500.dp),
                    contentPadding = PaddingValues(Constants.Size.small),
                    verticalArrangement = Arrangement.spacedBy(Constants.Size.medium),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    items(items = HomeProjectsElements.projects) {
                        ProjectCard(
                            project = it,
                            onClick = { navigateToProjectScreen(it) }
                        )
                    }
                }
            }
        }
    }
}

private object HomeProjectsText {
    const val CURRENTLY = "Here is some projects that I have made (solo or with friends):"
}


private object HomeProjectsElements {
    val projects: List<Project> = listOf(
        Project(
            title = "Soul Searching",
            description = "An offline music application for Android 8 and above, with Jetpack Compose.",
            technologiesImages = listOf("kotlin.png","compose.png"),
            projectRepositoryUrl = "https://github.com/enteraname74/SoulSearching"
        ),
        Project(
            title = "Bagit Desktop",
            description = "A Desktop application for managing Git projects.",
            technologiesImages = listOf("rust.png","gtk.png", "libadwaita.png")
        ),
        Project(
            title = "Sweet Music",
            description = "An offline music application for Android 8 and above.",
            technologiesImages = listOf("kotlin.png"),
            projectRepositoryUrl = "https://github.com/enteraname74/SweetMusic"
        ),
        Project(
            title = "USMD BACK",
            description = "A server application, made for testing Ktor.",
            technologiesImages = listOf("kotlin.png", "ktor.png")
        ),
        Project(
            title = "Compose Web",
            description = "A web app, made for testing Compose for Web.",
            technologiesImages = listOf("kotlin.png","compose.png")
        )
    )
}