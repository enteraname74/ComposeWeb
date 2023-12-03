package view.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import model.Project
import view.composable.AppImage
import view.composable.HeaderBar
import view.utils.ColorUtils
import view.utils.Constants

@Composable
fun ProjectScreen(
    navigateBack: () -> Unit,
    project: Project
) {
    val uriHandler = LocalUriHandler.current

    Scaffold(
        topBar = {
            HeaderBar(
                title = project.title,
                navigateBack = navigateBack
            )
        },
        containerColor = ColorUtils.primary
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(
                    horizontal = Constants.Size.extraLarge2,
                    vertical = Constants.Size.medium
                ),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = project.description,
                color = ColorUtils.onPrimary,
                fontSize = Constants.TextSize.body2
            )

            project.projectRepositoryUrl?.let { repositoryUrl ->
                AppImage(
                    resource = "github.png",
                    contentDescription = "repository",
                    size = Constants.ImageSize.large,
                    onClick = { uriHandler.openUri(repositoryUrl) }
                )
            }

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(Constants.Size.medium)
            ) {
                items(items = project.technologiesImages) {  imageResource ->
                    AppImage(
                        resource = imageResource,
                        contentDescription = "",
                        size = Constants.ImageSize.large2
                    )
                }
            }
        }
    }
}