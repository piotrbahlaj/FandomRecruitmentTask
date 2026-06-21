package fandom.piotrbahlaj.project

import androidx.compose.runtime.Composable
import fandom.piotrbahlaj.project.core.di.ServiceLocator
import fandom.piotrbahlaj.project.features.images.presentation.ImagesScreen

@Composable
fun App() {
    ImagesScreen(ServiceLocator.imagesViewModel)
}
