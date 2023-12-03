package view.composable.homecomposable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeInformation() {
    HomeElement(
        title = "Home"
    ) {
        Column(modifier = Modifier.fillMaxSize()) {  }
    }
}