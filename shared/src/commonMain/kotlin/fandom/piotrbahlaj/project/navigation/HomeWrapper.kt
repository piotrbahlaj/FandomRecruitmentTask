package fandom.piotrbahlaj.project.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import fandom.piotrbahlaj.project.core.utilities.Constants
import fandom.piotrbahlaj.project.features.images.presentation.ImagesScreen
import fandom.piotrbahlaj.project.features.images.presentation.ImagesViewModel
import fandom.piotrbahlaj.project.features.titles.presentation.TitlesScreen
import fandom.piotrbahlaj.project.features.titles.presentation.TitlesViewModel

@Composable
fun HomeWrapper(
    titlesViewModel: TitlesViewModel,
    imagesViewModel: ImagesViewModel,
) {
    var selectedTab by rememberSaveable() { mutableStateOf(0) }

    Scaffold(
        topBar = {
            Column {
                TopAppBar(
                    title = {
                        Text(if (selectedTab == 0) Constants.Title else Constants.Images)
                    }
                )
                PrimaryTabRow(selectedTabIndex = selectedTab) {
                    Tab(
                        selected = selectedTab == 0,
                        onClick = { selectedTab = 0 },
                        text = { Text(Constants.Title) }
                    )
                    Tab(
                        selected = selectedTab == 1,
                        onClick = { selectedTab = 1 },
                        text = { Text(Constants.Images) }
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (selectedTab) {
                0 -> TitlesScreen(viewModel = titlesViewModel)
                1 -> ImagesScreen(viewModel = imagesViewModel)
            }
        }
    }
}