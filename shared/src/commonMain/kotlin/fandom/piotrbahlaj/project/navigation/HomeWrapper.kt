package fandom.piotrbahlaj.project.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import fandom.piotrbahlaj.project.features.images.presentation.ImagesScreen
import fandom.piotrbahlaj.project.features.images.presentation.ImagesViewModel
import fandom.piotrbahlaj.project.features.titles.presentation.TitlesScreen
import fandom.piotrbahlaj.project.features.titles.presentation.TitlesViewModel

@Composable
fun HomeWrapper(
    titlesViewModel: TitlesViewModel,
    imagesViewModel: ImagesViewModel,
) {
    var selectedTab by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            Column {
                TopAppBar(
                    title = {
                        Text(if (selectedTab == 0) "Titles" else "Images")
                    }
                )
                PrimaryTabRow(selectedTabIndex = selectedTab) {
                    Tab(
                        selected = selectedTab == 0,
                        onClick = { selectedTab = 0 },
                        text = { Text("Titles") }
                    )
                    Tab(
                        selected = selectedTab == 1,
                        onClick = { selectedTab = 1 },
                        text = { Text("Images") }
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            when (selectedTab) {
                0 -> TitlesScreen(viewModel = titlesViewModel)
                1 -> ImagesScreen(viewModel = imagesViewModel)
            }
        }
    }
}