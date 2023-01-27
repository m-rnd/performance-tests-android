package com.example.finews.ui.screen

import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.finews.ui.theme.FiNewsTheme
import com.example.presentation.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel
) {
    val context = LocalContext.current
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
            Button(onClick = {
                Toast.makeText(context, "This is a Sample Toast", Toast.LENGTH_SHORT)
                    .show()
            }) {
                Text("button")
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
        Greeting("Android")
    }
}