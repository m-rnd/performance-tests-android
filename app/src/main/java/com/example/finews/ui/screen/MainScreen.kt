package com.example.finews.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.finews.ui.theme.FiNewsTheme
import com.example.entity.uistate.MainUiState
import com.example.presentation.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel
) = with(viewModel) {
    val uiState by viewModel.uiState.collectAsState()
    MainContent(uiState = uiState, onDownloadClick = ::onDownloadClick)
}

@Composable
private fun MainContent(
    uiState: MainUiState,
    onDownloadClick: () -> Unit
) {
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Greeting("Android")
            Text(text = "Download", modifier = Modifier.clickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
                onClick = onDownloadClick
            ))
            Button(enabled = uiState !is MainUiState.Loading, onClick = onDownloadClick) {
                Text("download")
            }
            if (uiState is MainUiState.Loading) {
                Text("downloading...")
            }
        }
    }
}


@Composable
private fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    FiNewsTheme {
        MainContent(uiState = MainUiState.Init) {

        }
    }
}