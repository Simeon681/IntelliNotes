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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
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
    onDocSelect: (MultipartBody.Part) -> Unit,
    onMockSelect: () -> Unit
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
                    onDocSelect = onDocSelect,
                    onMockSelect = onMockSelect
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

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen(
        navController = NavHostController(LocalContext.current),
        expanded = false,
        onExpandedChange = {},
        materials = listOf(
            MaterialResponse(
                id = "1",
                title = "VPN Explained",
                description = "VPN Explained",
                createdAt = "1710557910000",
                audioUrl = null,
                text = "You've probably heard of a VPN before. It's even possible you've used one before. But do you know what it does? A VPN stands for Virtual Private Network, which basically means it gives you privacy online. Originally, VPNs were only used in business settings where big businesses, organizations, or governments wanted to secure their data. Since people worked remotely and needed to connect online, businesses needed to create a secure connection. Otherwise, they were at risk for hacking or other loss of data. Nowadays, VPNs are used by everyone, specifically because it ensures your location stays private. Your data is encrypted and that you can surf the web anonymously. But how does it work? Let's back up for a second to understand how the internet works. When you visit a site like Facebook or Twitter, you type in a domain name. That domain is basically a nickname for the website's IP address. An IP address is just like your home address. Only it consists of numbers and not street names. Since it's much easier to remember names than a string of numbers, we give websites domain names and a server translates them. Your computer has an IP address too, and so does every device browsing the internet. When you type in the website's domain name on your browser, whether you're using Chrome, Firefox, or even Internet Explorer, you send your data into the internet until it reaches a server. That server then translates the data and sends you back the website you requested. The problem is, when you send that data to the server, you're sending them your IP address and a lot of other information too. This is where hackers can intercept your information. Imagine you're sitting in a coffee shop using their public Wi-Fi on your phone and you want to check your bank account. Someone else with the laptop can easily log into the network and get a hold of your passwords, emails, and other information you might have. But if you use a VPN, they won't be able to access that. The websites you visit can also gather your information, but they tend to do it in order to study their demographic. Usually, it's not a problem, but sometimes you want to protect your identity and privacy. So how does a VPN protect my privacy? When you send information online, a VPN creates a tunnel that encrypts your information. This way, if someone gets a hold of your data, they won't be able to read it. The tunnel also makes it harder to hack in, but don't be fooled. It is still possible, just much harder to do. A VPN also adds in an extra server. We spoke about how you send data from your computer to a server and then that server pings you back with the website. But with VPN, your data goes to their server first and then it's sent out to the website. This extra step helps in a lot of ways. First, it can change your location. A lot of video streaming websites like Netflix and Hulu have strict content depending on your geolocation. Let's say you want to watch your favorite show on Netflix, but it's not available in your country. You send your information to one of the VPN servers in America and the net server sends it to the Netflix website. Netflix now thinks you're in America and you can stream your show without any problems. A VPN tricks them into thinking you're in a different location because the signal is coming from a different server. Clever, right? Changing your location can also be helpful when booking a hotel or flight. Research has shown that hotels and flight prices change depending on your location and a VPN could potentially save you lots of money. But let's get back to your privacy. Remember how we mentioned websites sometimes collect your data? Well, many times governments can request this information and use the listed IP addresses to track your location. But with a VPN, their information only reaches the VPN server. They can't track you back to your original IP address. See how cool that is? Many VPNs also have a no logs policy, which means they don't record what sites you visit. So if the government requests a VPN provider for tracking logs, your information won't be there. VPNs are really handy when it comes to keeping your privacy safe on the web by changing your location, encrypting your data, and ensuring your privacy. It's no wonder so many people use them these days. Now that you know what a VPN is, it's time to go get one. Click on the link to see our top VPNs or click the icon below to share this video with your friends.\",\n" +
                        "",
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
                tags = listOf("VPN", "Technology"),
                questions = listOf()
            ),
            MaterialResponse(
                id = "2",
                title = "Human Anatomy",
                description = "Human Anatomy",
                createdAt = "1710557000000",
                audioUrl = null,
                text = "The human body is the entire structure of a human being. It is composed of many different types of cells that together create tissues and subsequently organs and then organ systems. They ensure homeostasis and the viability of the human body.\n" +
                        "\n" +
                        "It consists of head, hair, neck, torso (which includes the thorax and abdomen), arms and hands, legs and feet.\n" +
                        "\n" +
                        "The study of the human body includes anatomy, physiology, histology and embryology. The body varies anatomically in known ways. Physiology focuses on the systems and organs of the human body and their functions. Many systems and mechanisms interact in order to maintain homeostasis, with safe levels of substances such as sugar and oxygen in the blood.\n" +
                        "\n" +
                        "The body is studied by health professionals, physiologists, anatomists, and artists to assist them in their work.",
                summary = "The human body is the entire structure of a human being. It is composed of many different types of cells that together create tissues and subsequently organs and then organ systems. They ensure homeostasis and the viability of the human body.\n" +
                        "\n" +
                        "It consists of head, hair, neck, torso (which includes the thorax and abdomen), arms and hands, legs and feet.\n" +
                        "\n" +
                        "The study of the human body includes anatomy, physiology, histology and embryology. The body varies anatomically in known ways. Physiology focuses on the systems and organs of the human body and their functions. Many systems and mechanisms interact in order to maintain homeostasis, with safe levels of substances such as sugar and oxygen in the blood.\n" +
                        "\n" +
                        "The body is studied by health professionals, physiologists, anatomists, and artists to assist them in their work.",
                plan = "1. Introduction to the Human Body:\n" +
                        "\n" +
                        "- Define the human body as the entire structure of a human being.\n" +
                        "- Mention that it is composed of various cells, tissues, organs, and organ systems.\n" +
                        "2. Composition of the Human Body:\n" +
                        "\n" +
                        "- Discuss how different types of cells combine to form tissues, organs, and organ systems.\n" +
                        "- List the major components of the human body, including the head, hair, neck, torso (thorax and abdomen), arms, hands, legs, and feet.\n" +
                        "3. Functions and Homeostasis:\n" +
                        "\n" +
                        "- Explain that the human body functions to maintain homeostasis and ensure its viability.\n" +
                        "- Mention the role of various systems and mechanisms in regulating substances such as sugar and oxygen in the blood.\n" +
                        "4. Study of the Human Body:\n" +
                        "\n" +
                        "- Describe the disciplines involved in the study of the human body, including anatomy, physiology, histology, and embryology.\n" +
                        "- Discuss how health professionals, physiologists, anatomists, and artists study the human body to assist them in their respective fields.\n" +
                        "5. Variability and Interactions:\n" +
                        "\n" +
                        "- Highlight the anatomical variability observed in the human body.\n" +
                        "- Discuss the complex interactions between different systems and mechanisms to maintain homeostasis.\n" +
                        "7. Conclusion:\n" +
                        "\n" +
                        "- Summarize the importance of understanding the human body for various fields and professions.\n" +
                        "- Emphasize the interdisciplinary nature of studying the human body and its significance in advancing medical science and healthcare.",
                tags = listOf("Biology", "HumanAnatomy"),
                questions = listOf()
            ),
        ),
        onTextSelect = {},
        onMusicSelect = {},
        onDocSelect = {},
        onMockSelect = {}
    )
}
