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
fun PlanScreen(
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
                        text = material.plan,
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
fun PlanScreenPreview() {
    PlanScreen(
        material = MaterialResponse(
            id = "1",
            title = "History of Rome",
            description = "History of Rome",
            createdAt = "1710557910000",
            audioUrl = null,
            text = "There is archaeological evidence of human occupation of the Rome area from at least 5,000 years, but the dense layer of much younger debris obscures Palaeolithic and Neolithic sites.[4] The evidence suggesting the city's ancient foundation is also obscured by the legend of Rome's beginning involving Romulus and Remus.\n" +
                    "\n" +
                    "The traditional date for the founding of Rome is 21 April 753 BC, following M. Terentius Varro,[5] and the city and surrounding region of Latium has continued to be inhabited with little interruption since around that time. Excavations made in 2014 have revealed a wall built long before the city's official founding year. Archaeologists uncovered a stone wall and pieces of pottery dating to the 9th century BC and the beginning of the 8th century BC, and there is evidence of people arriving on the Palatine hill as early as the 10th century BC.[6][7]",
            summary = "There is archaeological evidence of human occupation of the Rome area from at least 5,000 years, but the dense layer of much younger debris obscures Palaeolithic and Neolithic sites.[4] The evidence suggesting the city's ancient foundation is also obscured by the legend of Rome's beginning involving Romulus and Remus.\n" +
                    "\n" +
                    "The traditional date for the founding of Rome is 21 April 753 BC, following M. Terentius Varro,[5] and the city and surrounding region of Latium has continued to be inhabited with little interruption since around that time. Excavations made in 2014 have revealed a wall built long before the city's official founding year. Archaeologists uncovered a stone wall and pieces of pottery dating to the 9th century BC and the beginning of the 8th century BC, and there is evidence of people arriving on the Palatine hill as early as the 10th century BC.[6][7]",
            plan = "What is a VPN?\n\nA VPN (Virtual Private Network) is a tool that provides online privacy and anonymity by creating a secure, encrypted connection between your device and the internet.\n\nHow VPNs Work\n\n1. When you connect to a VPN, your data is sent through an encrypted tunnel to the VPN server.\n2. The VPN server acts as an intermediary between your device and the internet, masking your IP address and location.\n3. Websites and online services you access will only see the VPN server's IP address, not your real one.\n\nBenefits of Using a VPN\n\n- Encrypts your data, making it unreadable to hackers and other third parties\n- Hides your IP address and location, providing anonymity online\n- Allows you to bypass geo-restrictions and access content from anywhere in the world\n- Protects your privacy when using public Wi-Fi networks\n\n## How VPNs Protect Your Privacy\n\n1. Encryption: VPNs use strong encryption algorithms to secure your data, making it unreadable to anyone who intercepts it.\n2. IP Masking: By hiding your real IP address, VPNs make it difficult for websites, advertisers, and governments to track your online activities.\n3. No-Logs Policy: Many reputable VPN providers have a strict no-logs policy, meaning they don't keep records of your online activities.\n\n## Additional Benefits of VPNs\n\n- Bypassing geo-restrictions: VPNs allow you to access content that may be restricted in your country, such as streaming services or websites.\n- Potential savings: Using a VPN to change your virtual location can sometimes result in lower prices for online services, such as flights or hotels.\n\nIn summary, VPNs are powerful tools that provide online privacy, security, and freedom by encrypting your data, masking your IP address, and allowing you to access content from anywhere in the world.\n",
            tags = listOf("History", "Rome", "Ancient"),
            questions = listOf()
        )
    )
}
