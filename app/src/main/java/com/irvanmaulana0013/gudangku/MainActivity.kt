package com.irvanmaulana0013.gudangku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.irvanmaulana0013.gudangku.ui.screen.MainScreen
import com.irvanmaulana0013.gudangku.ui.theme.GudangkuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GudangkuTheme {
                MainScreen()
            }
        }
    }
}
