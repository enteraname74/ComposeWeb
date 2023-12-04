package view.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import model.Project
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import view.composable.HeaderBar
import view.composable.project.ProjectDescriptionComposable
import view.composable.project.ProjectTechnologiesComposable
import view.utils.ColorUtils
import view.utils.Constants

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ProjectScreen(
    navigateBack: () -> Unit,
    project: Project
) {
    val isMinimised = LocalWindowInfo.current.containerSize.width <= 600

    Scaffold(
        topBar = {
            HeaderBar(
                title = project.title,
                navigateBack = navigateBack
            )
        },
        containerColor = ColorUtils.primary
    ) {
        if (isMinimised) {
            MinimisedView(
                paddingValues = it,
                project = project
            )
        } else {
            ExpandedView(
                paddingValues = it,
                project = project
            )
        }
    }
}

@Composable
private fun ExpandedView(
    paddingValues: PaddingValues,
    project: Project
) {
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        contentPadding = PaddingValues(
            horizontal = Constants.Size.extraLarge2,
            vertical = Constants.Size.medium
        ),
        verticalArrangement = Arrangement.spacedBy(Constants.Size.medium)
    ) {
        item {
            Row(
                horizontalArrangement = Arrangement.spacedBy(Constants.Size.medium)
            ) {
                ProjectDescriptionComposable(
                    modifier = Modifier
                        .weight(1.0f)
                        .fillMaxHeight(),
                    description = project.description,
                    repositoryUrl = project.projectRepositoryUrl
                )
                ProjectTechnologiesComposable(
                    modifier = Modifier
                        .weight(1.0f)
                        .fillMaxHeight(),
                    technologiesImages = project.technologiesImages
                )
            }
        }
        if (project.projectImages.isNotEmpty()) {
            this.ProjectImagesComposable(
                imagesResources = project.projectImages
            )
        }
    }
}

@Composable
private fun MinimisedView(
    paddingValues: PaddingValues,
    project: Project
) {
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        contentPadding = PaddingValues(
            horizontal = Constants.Size.extraLarge2,
            vertical = Constants.Size.medium
        ),
        verticalArrangement = Arrangement.spacedBy(Constants.Size.medium)
    ) {
        item {
            ProjectDescriptionComposable(
                modifier = Modifier.fillMaxWidth(),
                description = project.description,
                repositoryUrl = project.projectRepositoryUrl
            )
        }
        item {
            ProjectTechnologiesComposable(
                modifier = Modifier.fillMaxWidth(),
                technologiesImages = project.technologiesImages
            )
        }
        if (project.projectImages.isNotEmpty()) {
            this.ProjectImagesComposable(
                imagesResources = project.projectImages
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class, ExperimentalFoundationApi::class, ExperimentalResourceApi::class)
private fun LazyListScope.ProjectImagesComposable(
    imagesResources: List<String>
) {
    stickyHeader {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = ColorUtils.primary
                )
                .padding(vertical = Constants.Size.medium)
        ) {
            Text(
                text = "Images of the project",
                color = ColorUtils.highlight,
                fontWeight = FontWeight.Bold,
                fontSize = Constants.TextSize.body1
            )
        }
    }

    item {
        FlowRow(
            modifier = Modifier
                .padding(Constants.Size.medium)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(Constants.Size.medium),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            imagesResources.forEach {
                Image(
                    modifier = Modifier
                        .size(500.dp),
                    painter = painterResource(it),
                    contentDescription = "project image",
                    contentScale = ContentScale.Fit,
                )
            }
        }
    }
}