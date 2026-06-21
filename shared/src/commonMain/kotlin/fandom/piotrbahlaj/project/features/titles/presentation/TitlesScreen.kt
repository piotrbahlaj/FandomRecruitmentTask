package fandom.piotrbahlaj.project.features.titles.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState

@Composable
fun TitlesScreen(
    viewModel: TitlesViewModel,
) {
    val state = viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadTitles()
    }
}