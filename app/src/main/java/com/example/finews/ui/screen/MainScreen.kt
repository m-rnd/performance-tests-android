package com.example.finews.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.finews.ui.theme.FiNewsTheme
import com.example.presentation.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel
) = with(viewModel) {
    MainContent(onDownloadClick = ::onDownloadClick)
}

@Composable
private fun MainContent(
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
            Button(onClick = onDownloadClick) {
                Text("download")
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
        MainContent {

        }
    }
}