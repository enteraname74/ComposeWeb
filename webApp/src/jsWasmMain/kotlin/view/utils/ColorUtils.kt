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
        get() = animateColorAsState(
            targetValue = getPalette().primary,
            animationSpec = tween(Constants.AnimationDuration.normal)
        ).value

    val secondary: Color
        @Composable
        get() = animateColorAsState(
            targetValue = getPalette().secondary,
            animationSpec = tween(Constants.AnimationDuration.normal)
        ).value

    val onPrimary: Color
        @Composable
        get() = animateColorAsState(
            targetValue = getPalette().onPrimary,
            animationSpec = tween(Constants.AnimationDuration.normal)
        ).value

    val onSecondary: Color
        @Composable
        get() = animateColorAsState(
            targetValue = getPalette().onSecondary,
            animationSpec = tween(Constants.AnimationDuration.normal)
        ).value

    val highlight: Color
        @Composable
        get() = animateColorAsState(
            targetValue = getPalette().highlight,
            animationSpec = tween(Constants.AnimationDuration.normal)
        ).value

    /**
     * Retrieve the palette to use for the application.
     */
    private fun getPalette(): Palette {
        println(currentShownElement)
        return when (currentShownElement) {
            HomeElementsPosition.HOME, 1 -> HOME_PALETTE
            HomeElementsPosition.TECHNOLOGIES, 3 -> TECHNOLOGIES_PALETTE
            HomeElementsPosition.PROJECTS, 5 -> PROJECTS_PALETTE
            HomeElementsPosition.ABOUT, 7 -> ABOUT_PALETTE
            else -> HOME_PALETTE
        }
    }

    private val HOME_PALETTE = Palette(
        primary = Color(0xff1c3c60),
        secondary = Color(0xff2c6099),
        highlight = Color(0xffDBE0E5),
        onPrimary = Color(0xff8294A8),
        onSecondary = Color(0xffAFBED5)
    )
    private val CV_PALETTE = Palette(
        primary = Color(0xff480000),
        secondary = Color(0xff730000)
    )
    private val TECHNOLOGIES_PALETTE = Palette(
        primary = Color(0xff084038),
        secondary = Color(0xff0c6659),
        onPrimary = Color(0xff9CB3AF),
        highlight = Color(0xffD7E1DF),
        onSecondary = Color(0xff9EC2BD)
    )
    private val PROJECTS_PALETTE = Palette(
        primary = Color(0xff643004),
        secondary = Color(0xffa04c06),
        onPrimary = Color(0xffC1AC9B),
        highlight = Color(0xffE6DED7),
        onSecondary = Color(0xffD9B79B)
    )

    private val ABOUT_PALETTE = Palette(
        primary = Color(0xff480000),
        secondary = Color(0xff730000),
        onPrimary = Color(0xffB69999),
        highlight = Color(0xffE2D6D6),
        onSecondary = Color(0xffC79999)
    )
}