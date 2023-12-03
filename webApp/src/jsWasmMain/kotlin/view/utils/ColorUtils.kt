package view.utils

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

/**
 * Colors used by the application.
 */
object ColorUtils {
    var currentShownElement by mutableStateOf(HomeElementsPosition.HOME)

    val primary: Color
        @Composable
        get() = animateColorAsState(targetValue = getPalette().primary, animationSpec = tween(300)).value

    val secondary: Color
        @Composable
        get() = animateColorAsState(targetValue = getPalette().secondary, animationSpec = tween(300)).value

    val onPrimary: Color
        @Composable
        get() = animateColorAsState(targetValue = getPalette().textColor, animationSpec = tween(300)).value

    val onSecondary: Color
        @Composable
        get() = animateColorAsState(targetValue = getPalette().textColor, animationSpec = tween(300)).value

    /**
     * Retrieve the palette to use for the application.
     */
    private fun getPalette(): Palette {
        return when(currentShownElement) {
            HomeElementsPosition.HOME -> HOME_PALETTE
            HomeElementsPosition.DESCRIPTION -> DESCRIPTION_PALETTE
            HomeElementsPosition.TECHNOLOGIES -> TECHNOLOGIES_PALETTE
            HomeElementsPosition.PROJECTS -> PROJECTS_PALETTE
            HomeElementsPosition.ABOUT -> ABOUT_PALETTE
            else -> HOME_PALETTE
        }
    }

    private val HOME_PALETTE = Palette(
        primary = Color(0xff1c3c60),
        secondary = Color(0xff2c6099)
    )
    private val DESCRIPTION_PALETTE = Palette(
        primary = Color(0xff480000),
        secondary = Color(0xff730000)
    )
    private val TECHNOLOGIES_PALETTE = Palette(
        primary = Color(0xff084038),
        secondary = Color(0xff0c6659)
    )
    private val PROJECTS_PALETTE = Palette(
        primary = Color(0xff643004),
        secondary = Color(0xffa04c06)
    )
    private val ABOUT_PALETTE = Palette(
        primary = Color(0xff1c3c60),
        secondary = Color(0xff2c6099)
    )

}