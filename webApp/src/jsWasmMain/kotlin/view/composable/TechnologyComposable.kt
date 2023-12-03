package view.composable

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import view.utils.ColorUtils
import view.utils.Constants

@Composable
fun TechnologyComposable(
    title: String,
    technologiesImages: List<String>
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(Constants.Size.small)
    ) {
        Text(
            text = title,
            color = ColorUtils.onPrimary,
            fontSize = Constants.TextSize.body1,
            fontWeight = FontWeight.Bold
        )
        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(Constants.Size.medium)
        ) {
            technologiesImages.forEach {
                AppImage(
                    resource = it,
                    contentDescription = "",
                    size = Constants.ImageSize.medium2
                )
            }
        }
    }
}