package com.faridnia.metime.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.faridnia.metime.presentation.nav_graph.NavGraph

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeTimeTheme {

                val navController = rememberNavController()
                var actionBarTitle by rememberSaveable { mutableStateOf("") }
                var hideBackButtonOnTopBar by rememberSaveable { mutableStateOf(false) }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        modifier = Modifier
                            .fillMaxSize(),
                        containerColor = MaterialTheme.colorScheme.surface,
                        bottomBar = {
                        },
                        topBar = {
                        }
                    ) { values ->
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(values)
                        ) {
                            NavGraph(
                                navController = navController,
                            ) { title, hideBackButton ->
                                actionBarTitle = title ?: ""
                                hideBackButtonOnTopBar = hideBackButton
                            }
                        }
                    }

                }
            }
        }
    }
}
