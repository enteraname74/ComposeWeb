package view.composable.home.parts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import view.composable.AppImage
import view.composable.CircleComposable
import view.utils.ColorUtils
import view.utils.Constants

@Composable
fun HomeInformation() {
    val uriHandler = LocalUriHandler.current

    HomeElement {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopStart),
                verticalArrangement = Arrangement.spacedBy(Constants.Size.medium)
            ) {
                Text(
                    text = "Hi, my name is",
                    color = ColorUtils.onPrimary,
                    fontSize = Constants.TextSize.body2
                )
                Text(
                    text = HomeInformationText.NAME,
                    color = ColorUtils.highlight,
                    fontSize = Constants.TextSize.headline,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = HomeInformationText.MAIN_TEXT,
                    color = ColorUtils.onPrimary,
                    fontSize = Constants.TextSize.body2,
                )
                Text(
                    text = HomeInformationText.SUB_TEXT,
                    color = ColorUtils.onPrimary,
                    fontSize = Constants.TextSize.body2
                )
                AppImage(
                    resource = "github.png",
                    contentDescription = "Github profile",
                    size = Constants.ImageSize.medium2,
                    onClick = { uriHandler.openUri("https://github.com/enteraname74") }
                )
            }
            HomeInformationDesignElements()
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun BoxScope.HomeInformationDesignElements() {

    val maxWidth = LocalWindowInfo.current.containerSize.width

    Spacer(
        modifier = Modifier
            .width(5.dp)
            .fillMaxHeight()
            .background(
                color = ColorUtils.secondary,
                shape = RoundedCornerShape(50)
            )
            .align(Alignment.BottomEnd)
    )
    if (maxWidth > 500) {
        Row(
            modifier = Modifier
                .align(Alignment.BottomStart),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.spacedBy(Constants.Size.medium)
        ) {
            CircleComposable(size = Constants.Size.extraLarge)
            CircleComposable(size = Constants.Size.large)
        }
    }
}

private object HomeInformationText {
    const val NAME = "Noah Penin"
    const val MAIN_TEXT = "I'm a student at the Université Savoie Mont Blanc in Computer Science!\n" +
            "I love doing Android applications and discovering new things, specially around the Kotlin language!"
    const val SUB_TEXT = "I always make sure to fight for the code with a burning passion."
}

