package view.composable.home.parts

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.ApplicationData
import view.composable.TechnologyComposable
import view.utils.ColorUtils
import view.utils.Constants

@Composable
fun HomeTechnologies() {
    HomeElement {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopStart),
                verticalArrangement = Arrangement.spacedBy(Constants.Size.medium)
            ) {
                Text(
                    text = HomeTechnologiesText.CURRENTLY,
                    color = ColorUtils.onPrimary,
                    fontSize = Constants.TextSize.body2
                )

                LazyVerticalGrid(
                    modifier = Modifier.fillMaxWidth(),
                    columns = GridCells.FixedSize(200.dp),
                    contentPadding = PaddingValues(Constants.Size.small),
                    verticalArrangement = Arrangement.spacedBy(Constants.Size.medium),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    items(items = ApplicationData.technologies) {
                        TechnologyComposable(
                            title = it.title,
                            technologiesImages = it.technologiesImages
                        )
                    }
                }
            }
        }
    }
}

private object HomeTechnologiesText {
    const val CURRENTLY = "I love working with Kotlin related technologies such as Ktor or Compose (Android, Desktop, Web).\n" +
            "Because of the fact that I work with Linux (Fedora with Gnome), I also like to work with technologies like GTK, Libadwaita and Rust!"
}