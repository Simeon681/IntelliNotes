package com.example.intellinotes.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

@Composable
fun CustomFloatingActionButton(
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    onMusicSelect: (MultipartBody.Part) -> Unit,
    onDocSelect: (MultipartBody.Part) -> Unit,
) {
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    val getContent = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { result: Uri? ->
        result?.let { uri ->
            selectedImageUri = uri
        }
    }

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
                        onClick = {
                            getContent.launch("audio/mp3")
                        },
                        shape = CircleShape,
                        containerColor = Color.LightGray,
                        contentColor = Color.Cyan
                    ) {
                        Icon(
                            imageVector = Icons.Default.AudioFile,
                            contentDescription = null
                        )
                    }
                    selectedImageUri?.let {
                        val file = File(it.path.toString())
                        val multipart = fileToMultipart(file)
                        onMusicSelect(multipart)
                    }

                    Spacer(modifier = Modifier.padding(4.dp))

                    FloatingActionButton(
                        onClick = {
                            getContent.launch("document/*")
                        },
                        shape = CircleShape,
                        containerColor = Color.LightGray,
                        contentColor = Color.Cyan
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.TextSnippet,
                            contentDescription = null
                        )
                    }
                    selectedImageUri?.let {
                        val file = File(it.path.toString())
                        val multipart = fileToMultipart(file)
                        onDocSelect(multipart)
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

fun fileToMultipart(file: File): MultipartBody.Part {
    // Create RequestBody instance from file
    val requestFile = file.asRequestBody("audio/mpeg".toMediaTypeOrNull())

    // Create MultipartBody.Part instance
    return MultipartBody.Part.createFormData("files", file.name, requestFile)
}
