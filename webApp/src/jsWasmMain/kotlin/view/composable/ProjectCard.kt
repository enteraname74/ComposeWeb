package view.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import view.utils.ColorUtils
import view.utils.Constants

@Composable
fun ProjectCard(
    name: String,
    description: String,
    tags: List<String> = emptyList(),
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
            ),
        colors = CardDefaults.cardColors(
            containerColor = ColorUtils.primary
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(Constants.Size.small),
            verticalArrangement = Arrangement.spacedBy(Constants.Size.medium)
        ) {
            Text(
                text = name,
                color = ColorUtils.onPrimary,
                fontSize = Constants.TextSize.body1,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = description,
                color = ColorUtils.onPrimary,
                fontSize = Constants.TextSize.body2,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomEnd
            ) {
                Button(
                    onClick = onClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ColorUtils.secondary
                    )
                ) {
                    Text(
                        text =  "See more",
                        color = ColorUtils.onSecondary,
                        fontSize = Constants.TextSize.body2,
                    )
                }
            }
        }
    }
}