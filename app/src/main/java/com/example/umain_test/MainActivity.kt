package com.example.umain_test

import android.os.Build
import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext

import com.example.umain_test.navigation.ApplicationNavigation

import com.example.umain_test.ui.theme.Umain_testTheme


import com.example.umain_test.viewmmodel.MainViewModel

import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MainApp {
                ApplicationNavigation()
            }

        }
    }
    @Composable
    fun MainApp(content: @Composable () -> Unit) {
        Umain_testTheme {
            content()
        }
    }
}

