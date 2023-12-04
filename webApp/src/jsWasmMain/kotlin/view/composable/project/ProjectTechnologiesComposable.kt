package view.composable.project

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import view.composable.AppImage
import view.utils.ColorUtils
import view.utils.Constants

@Composable
fun ProjectTechnologiesComposable(
    modifier: Modifier = Modifier,
    technologiesImages: List<String>
) {
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
                text = "Technologies",
                color = ColorUtils.highlight,
                fontWeight = FontWeight.Bold,
                fontSize = Constants.TextSize.body1
            )
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(Constants.Size.medium)
            ) {
                items(items = technologiesImages) { imageResource ->
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