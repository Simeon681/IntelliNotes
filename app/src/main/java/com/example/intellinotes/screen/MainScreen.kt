package com.example.intellinotes.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.intellinotes.components.CustomFloatingActionButton
import com.example.intellinotes.components.MaterialCard
import com.example.intellinotes.dto.response.MaterialResponse
import okhttp3.MultipartBody

@Composable
fun MainScreen(
    navController: NavHostController,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    materials: List<MaterialResponse>,
    onTextSelect: () -> Unit,
    onMusicSelect: (MultipartBody.Part) -> Unit,
    onDocSelect: (MultipartBody.Part) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.White
    ) {
        Scaffold(
            floatingActionButton = {
                CustomFloatingActionButton(
                    expanded = expanded,
                    onExpandedChange = onExpandedChange,
                    onMusicSelect = onMusicSelect,
                    onDocSelect = onDocSelect
                )
            }
        ) { innerPadding ->
            val lazyListState = rememberLazyListState()
            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(start = 14.dp, top = 16.dp, end = 14.dp),
                state = lazyListState
            ) {
                item {
                    Text(
                        text = "Materials",
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(),
                        style = TextStyle(
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Normal
                        ),
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(16.dp))

//                    CustomSearchBar(
//                        query = "",
//                        onQueryChange = {},
//                        active = true,
//                        onActiveChange = {},
//                        onSearchButtonClick = {}
//                    )

                    materials.forEach {
                        MaterialCard(
                            navController = navController,
                            title = it.title,
                            text = it.text,
                            createdAt = it.createdAt,
                            tags = it.tags,
                            id = it.id,
                        )

                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    }
}
