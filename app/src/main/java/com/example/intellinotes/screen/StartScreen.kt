package com.example.intellinotes.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.intellinotes.R
import kotlinx.coroutines.delay

@Composable
fun StartScreen(
    navController: NavController
) {
    LaunchedEffect(key1 = true) {
        delay(2000)
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 28.dp, end = 28.dp),
        color = Color.White,
    ) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.intellinotes),
                contentDescription = null
            )
        }
    }

    navController.navigate("login")
}

@Preview
@Composable
fun StartScreenPreview() {
    StartScreen(navController = NavController(LocalContext.current))
}
