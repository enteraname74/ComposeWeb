import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import view.utils.ColorUtils

object ComposeWebColors {
    val background = Color(0xFFFFFFFF)
    val onBackground = Color(0xFF19191C)
}

@Composable
fun ComposeWebTheme(content: @Composable () -> Unit) {
    isSystemInDarkTheme() // todo check and change colors
    MaterialTheme(
        colorScheme = MaterialTheme.colorScheme.copy(
            background = ComposeWebColors.background,
            onBackground = ComposeWebColors.onBackground
        )
    ) {
        ProvideTextStyle(LocalTextStyle.current.copy(letterSpacing = 0.sp)) {
            // The Surface composable seems to be necessary as the first element for the app to work properly
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = ColorUtils.primary
                    )
            ) {
                content()
            }
        }
    }
}
