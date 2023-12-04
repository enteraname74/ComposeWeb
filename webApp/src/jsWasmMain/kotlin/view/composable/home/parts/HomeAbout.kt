package view.composable.home.parts

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import view.composable.AppImage
import view.utils.ColorUtils
import view.utils.Constants

@Composable
fun HomeAbout() {
    HomeElement {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(Constants.Size.medium),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = HomeAboutText.EXPLANATION,
                    color = ColorUtils.onPrimary,
                    fontSize = Constants.TextSize.body2
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = Constants.Size.medium),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    AppImage(
                        resource = "compose.png",
                        contentDescription = "",
                        size = Constants.ImageSize.huge
                    )
                    AppImage(
                        resource = "kotlin.png",
                        contentDescription = "",
                        size = Constants.ImageSize.huge
                    )
                }
            }
        }
    }
}
private object HomeAboutText {
    const val EXPLANATION = "This website was made as an experiment with Compose for Web, Kotlin, and a lot of love.\n"
}
