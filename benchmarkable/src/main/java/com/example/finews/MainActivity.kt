package com.example.finews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.finews.ui.navigation.NavigationComponent
import com.example.finews.ui.theme.FiNewsTheme
import com.example.interactor.Navigator
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigator: Navigator
    override fun onCreate(savedInstanceState: Bundle?) {
//        if (BuildConfig.DEBUG) {
//            Timber.plant(Timber.DebugTree())
//        }

        super.onCreate(savedInstanceState)
        setContent {
            FiNewsTheme {
                NavigationComponent(rememberNavController(), navigator)
            }
        }
    }
}