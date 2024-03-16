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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.intellinotes.dto.response.MaterialResponse

@Composable
fun SummaryScreen(
    material: MaterialResponse
) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.White
    ) {
        Scaffold { innerPadding ->
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
                        text = material.summary,
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
                }
            }
        }
    }
}

@Preview
@Composable
fun SummaryScreenPreview() {
    SummaryScreen(
        material = MaterialResponse(
            id = "1",
            title = "History of Rome",
            description = "History of Rome",
            createdAt = "1710557910000",
            audioUrl = null,
            text = "There is archaeological evidence of human occupation of the Rome area from at least 5,000 years, but the dense layer of much younger debris obscures Palaeolithic and Neolithic sites.[4] The evidence suggesting the city's ancient foundation is also obscured by the legend of Rome's beginning involving Romulus and Remus.\n" +
                    "\n" +
                    "The traditional date for the founding of Rome is 21 April 753 BC, following M. Terentius Varro,[5] and the city and surrounding region of Latium has continued to be inhabited with little interruption since around that time. Excavations made in 2014 have revealed a wall built long before the city's official founding year. Archaeologists uncovered a stone wall and pieces of pottery dating to the 9th century BC and the beginning of the 8th century BC, and there is evidence of people arriving on the Palatine hill as early as the 10th century BC.[6][7]",
            summary = "Hey there! Let's break down what a VPN is and how it works in a simple way.\n\nA VPN, or Virtual Private Network, is a tool that helps keep your online activity private and secure. It's like a secret tunnel for your internet traffic.\n\nHere's how it works:\n1. When you use a VPN, your data gets encrypted (jumbled up) before it leaves your device. This makes it hard for anyone to snoop on what you're doing online.\n2. Your encrypted data goes to a VPN server before heading to the website you want to visit. This extra step hides your real location and IP address (your device's unique identifier).\n3. The website sees the VPN server's IP instead of yours, making it seem like you're browsing from a different place.\n\nWhy is this helpful?\n- It keeps your sensitive info (like passwords and bank details) safe on public Wi-Fi.\n- It lets you access content that might be blocked in your country, like streaming shows.\n- It stops websites from tracking your real location and identity.\n\nSo, a VPN is a handy tool for anyone who wants more privacy and freedom online. It's easy to use and can give you peace of mind while browsing. Pretty cool, right?",
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
        )
    )
}
