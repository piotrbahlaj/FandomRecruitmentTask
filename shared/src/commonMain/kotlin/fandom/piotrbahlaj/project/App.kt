package fandom.piotrbahlaj.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import coil3.compose.setSingletonImageLoaderFactory
import fandom.piotrbahlaj.project.core.config.createImageLoader
import fandom.piotrbahlaj.project.core.di.ServiceLocator
import fandom.piotrbahlaj.project.features.images.presentation.ImagesScreen

@Composable
fun App() {
    
    setSingletonImageLoaderFactory { context -> createImageLoader(context) }

    MaterialTheme {
        ImagesScreen(ServiceLocator.imagesViewModel)
    }
}
