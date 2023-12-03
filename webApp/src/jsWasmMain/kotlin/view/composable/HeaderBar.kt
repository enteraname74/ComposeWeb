package view.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import view.utils.ColorUtils
import view.utils.Constants

@Composable
fun HeaderBar(
    title: String,
    navigateBack: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Constants.Size.medium)
            .background(color = ColorUtils.primary),
        horizontalArrangement = Arrangement.spacedBy(Constants.Size.medium),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            imageVector = Icons.Rounded.ArrowBack,
            contentDescription = "Go back",
            colorFilter = ColorFilter.tint(color = ColorUtils.onPrimary),
            modifier = Modifier
                .size(Constants.ImageSize.medium)
                .clickable { navigateBack() }
        )
        Text(
            text = title,
            color = ColorUtils.onPrimary,
            fontSize = Constants.TextSize.headerBar
        )
    }
}