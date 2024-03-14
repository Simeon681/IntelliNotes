package com.example.intellinotes.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.TextSnippet
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AudioFile
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomFloatingActionButton(
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier.wrapContentSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(
            visible = expanded,
            enter = fadeIn() + expandVertically(),
            exit = fadeOut() + shrinkVertically()
        ) {
            LazyColumn(
                modifier = Modifier.wrapContentSize(),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                item {
                    FloatingActionButton(
                        onClick = { /*TODO*/ },
                        shape = CircleShape,
                        containerColor = Color.LightGray,
                        contentColor = Color.Cyan
                    ) {
                        Icon(
                            imageVector = Icons.Default.AudioFile,
                            contentDescription = null
                        )
                    }

                    Spacer(modifier = Modifier.padding(4.dp))

                    FloatingActionButton(
                        onClick = { /*TODO*/ },
                        shape = CircleShape,
                        containerColor = Color.LightGray,
                        contentColor = Color.Cyan
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.TextSnippet,
                            contentDescription = null
                        )
                    }

                    Spacer(modifier = Modifier.padding(8.dp))
                }
            }
        }
        FloatingActionButton(
            modifier = Modifier.size(70.dp),
            onClick = {
                onExpandedChange(!expanded)
            },
            shape = CircleShape,
            containerColor = Color.LightGray,
            contentColor = Color.Cyan,
        ) {
            Icon(
                Icons.Default.Add,
                contentDescription = null,
                Modifier.rotate(if (expanded) 45f else 0f)
            )
        }
    }
}
