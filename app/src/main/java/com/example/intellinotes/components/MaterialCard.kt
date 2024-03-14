package com.example.intellinotes.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MaterialCard(

) {
    val tags by remember{
        mutableStateOf(listOf("Author", "math", "history"))
    }

    val colors = listOf(
        Color(0xFFE57373),
        Color(0xFF81C784),
        Color(0xFF64B5F6),
        Color(0xFF9575CD),
        Color(0xFF4DB6AC),
        Color(0xFF7986CB),
        Color(0xFFA1887F),
        Color(0xFF90A4AE)
    )

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                //TODO
            },
        colors = CardDefaults.elevatedCardColors(
            Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Heading Text",
                    modifier = Modifier
                        .heightIn()
                        .weight(1f, true),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Normal
                    ),
                    color = Color.Black
                )

                Text(
                    text = getTimeAgo(1710421135000),
                    modifier = Modifier
                        .heightIn(),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontStyle = FontStyle.Normal
                    ),
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Description",
                maxLines = 5,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row {
                repeat(tags.size) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(colors.random())
                            .padding(6.dp)
                    ) {
                        Text(
                            text = "#${tags[it]}",
                            modifier = Modifier
                                .heightIn(),
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontStyle = FontStyle.Normal
                            ),
                            color = Color.LightGray
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    }
}

fun getTimeAgo(timestamp: Long): String {
    val currentTime = System.currentTimeMillis()
    val seconds = currentTime - timestamp
    val minutes = seconds / 60
    val hours = minutes / 60
    val days = hours / 24
    val weeks = days / 7
    val months = days / 30
    val years = days / 365

    return when {
        years > 0 -> "$years year${if (years > 1) "s" else ""} ago"
        months > 0 -> "$months month${if (months > 1) "s" else ""} ago"
        weeks > 0 -> "$weeks week${if (weeks > 1) "s" else ""} ago"
        days > 0 -> "$days day${if (days > 1) "s" else ""} ago"
        hours > 0 -> "$hours hour${if (hours > 1) "s" else ""} ago"
        minutes > 0 -> "$minutes minute${if (minutes > 1) "s" else ""} ago"
        else -> "$seconds second${if (seconds > 1) "s" else ""} ago"
    }
}

@Preview
@Composable
fun MaterialCardPreview() {
    MaterialCard()
}
