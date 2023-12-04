package view.composable.project

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import view.composable.AppImage
import view.utils.ColorUtils
import view.utils.Constants

@Composable
fun ProjectDescriptionComposable(
    modifier: Modifier = Modifier,
    description: String,
    repositoryUrl: String?
) {
    val uriHandler = LocalUriHandler.current

    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        modifier = Modifier
            .composed { modifier },
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
                text = "Description",
                color = ColorUtils.highlight,
                fontWeight = FontWeight.Bold,
                fontSize = Constants.TextSize.body1
            )
            Text(
                text = description,
                color = ColorUtils.onPrimary,
                fontSize = Constants.TextSize.body2
            )
            repositoryUrl?.let { repositoryUrl ->
                AppImage(
                    resource = "github.png",
                    contentDescription = "repository",
                    size = Constants.ImageSize.large,
                    onClick = { uriHandler.openUri(repositoryUrl) }
                )
            }
        }
    }
}