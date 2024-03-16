package com.example.intellinotes.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.FormatListNumbered
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.intellinotes.components.ExoVideoPlayer
import com.example.intellinotes.components.colors
import com.example.intellinotes.dto.response.MaterialResponse

@Composable
fun MaterialScreen(
    onGetMaterial: () -> Unit,
    material: MaterialResponse,
    onClick1: () -> Unit,
    onClick2: () -> Unit,
    onClick3: () -> Unit
) {
    LaunchedEffect(key1 = true) {
        onGetMaterial()
    }

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.White
    ) {
        Scaffold(
            bottomBar = {
                BottomAppBar(
                    contentColor = Color.Black,
                    containerColor = Color.Transparent
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        FilledIconButton(
                            onClick = {
                                onClick1()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.FormatListNumbered,
                                contentDescription = null
                            )
                        }

                        FilledIconButton(
                            onClick = {
                                onClick2()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.List,
                                contentDescription = null
                            )
                        }

                        FilledIconButton(
                            onClick = {
                                onClick3()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.QuestionMark,
                                contentDescription = null
                            )
                        }
                    }
                }
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
                        text = material.title,
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

                    Text(
                        text = material.text,
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(),
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Normal
                        ),
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    //ExoVideoPlayer(material.audioUrl.toString())

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn()
                    ) {
                        Text(
                            text = "Tags: ",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic
                        )

                        repeat(material.tags.size) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(colors.random())
                                    .padding(6.dp)
                            ) {
                                Text(
                                    text = "#${material.tags[it]}",
                                    modifier = Modifier
                                        .heightIn(),
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontStyle = FontStyle.Normal
                                    ),
                                    color = Color.White
                                )
                            }

                            Spacer(modifier = Modifier.width(8.dp))
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun MaterialScreenPreview() {
    MaterialScreen(
        onGetMaterial = {},
        material =
        MaterialResponse(
            id = "1",
            title = "History of Rome",
            description = "History of Rome",
            createdAt = "1710557910000",
            audioUrl = "https://nestjsimageupload.blob.core.windows.net/audio/6d760b2b-f57c-455a-87cd-dbf7ce517a07.mp3",
            text = "There is archaeological evidence of human occupation of the Rome area from at least 5,000 years, but the dense layer of much younger debris obscures Palaeolithic and Neolithic sites.[4] The evidence suggesting the city's ancient foundation is also obscured by the legend of Rome's beginning involving Romulus and Remus.\n" +
                    "\n" +
                    "The traditional date for the founding of Rome is 21 April 753 BC, following M. Terentius Varro,[5] and the city and surrounding region of Latium has continued to be inhabited with little interruption since around that time. Excavations made in 2014 have revealed a wall built long before the city's official founding year. Archaeologists uncovered a stone wall and pieces of pottery dating to the 9th century BC and the beginning of the 8th century BC, and there is evidence of people arriving on the Palatine hill as early as the 10th century BC.[6][7]",
            summary = "There is archaeological evidence of human occupation of the Rome area from at least 5,000 years, but the dense layer of much younger debris obscures Palaeolithic and Neolithic sites.[4] The evidence suggesting the city's ancient foundation is also obscured by the legend of Rome's beginning involving Romulus and Remus.\n" +
                    "\n" +
                    "The traditional date for the founding of Rome is 21 April 753 BC, following M. Terentius Varro,[5] and the city and surrounding region of Latium has continued to be inhabited with little interruption since around that time. Excavations made in 2014 have revealed a wall built long before the city's official founding year. Archaeologists uncovered a stone wall and pieces of pottery dating to the 9th century BC and the beginning of the 8th century BC, and there is evidence of people arriving on the Palatine hill as early as the 10th century BC.[6][7]",
            plan = "1. Introduction:\n" +
                    "\n" +
                    "- Brief overview of archaeological evidence of human occupation in Rome.\n" +
                    "- Mention the obscured Palaeolithic and Neolithic sites due to younger debris and the legend of Romulus and Remus.\n" +
                    "2. Early Human Occupation:\n" +
                    "\n" +
                    "- Discuss archaeological evidence suggesting human occupation of the Rome area dating back at least 5,000 years.\n" +
                    "- Mention the challenge of obscured Palaeolithic and Neolithic sites.\n" +
                    "3. Founding of Rome:\n" +
                    "\n" +
                    "- Introduce the traditional date for the founding of Rome as 21 April 753 BC, following M. Terentius Varro.\n" +
                    "- Discuss the legend of Romulus and Remus as the city's beginning, which obscures evidence of its ancient foundation.\n" +
                    "4. Recent Archaeological Discoveries:\n" +
                    "\n" +
                    "- Describe recent excavations made in 2014.\n" +
                    "- Mention the uncovering of a stone wall and pottery dating to the 9th and 8th centuries BC.\n" +
                    "- Discuss evidence of people arriving on the Palatine hill as early as the 10th century BC.\n" +
                    "5. Conclusion:\n" +
                    "\n" +
                    "- Summarize the significance of archaeological evidence in understanding the history of Rome.\n" +
                    "- Highlight the ongoing efforts in archaeological research to uncover more about the city's ancient past.",
            tags = listOf("History", "Rome", "Ancient"),
            questions = listOf()
        ),
        onClick1 = {},
        onClick2 = {},
        onClick3 = {}
    )
}
