package view.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import model.Project
import view.utils.ColorUtils
import view.utils.Constants

@Composable
fun ProjectCard(
    project: Project,
    onClick: () -> Unit
) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        modifier = Modifier
            .size(
                width = 500.dp,
                height = 250.dp
            )
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = ColorUtils.secondary
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(Constants.Size.medium),
            verticalArrangement = Arrangement.spacedBy(Constants.Size.medium)
        ) {
            Text(
                text = project.title,
                color = ColorUtils.highlight,
                fontSize = Constants.TextSize.body1,
                maxLines = 1,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = project.description,
                color = ColorUtils.onSecondary,
                fontSize = Constants.TextSize.body2,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomStart
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(Constants.Size.small)
                ) {
                    items(items = project.technologiesImages) {
                        AppImage(
                            resource = it,
                            contentDescription = "",
                            size = Constants.ImageSize.medium2
                        )
                    }
                }
            }
        }
    }
}