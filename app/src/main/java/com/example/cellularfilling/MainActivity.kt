package com.example.cellularfilling

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.toArgb
import com.example.cellularfilling.presentation.screens.MainScreen
import com.example.cellularfilling.ui.theme.Purple

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by lazy {
        MainViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = Purple.toArgb()
            val state by viewModel.state.collectAsState()
            MainScreen(state, viewModel::addCell)
        }
    }
}