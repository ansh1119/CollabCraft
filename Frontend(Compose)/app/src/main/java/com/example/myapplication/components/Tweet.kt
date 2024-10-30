package com.example.myapplication.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.models.TweetResponse
import com.example.myapplication.retrofitHelper.TokenManager
import com.example.myapplication.viewmodel.TweetViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Tweet(tweet: TweetResponse, tweetViewModel: TweetViewModel) {

    val Comissioner = FontFamily(
        Font(R.font.comissioner)
    )
    val context = LocalContext.current
    val tokenManager = remember { TokenManager(context) }
    val currentUserId = tokenManager.getUsername()
//    val now = LocalDateTime.now()
//    val postedTime=tweet.time
//    val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME
//    val postDateTime = LocalDateTime.parse(postedTime, formatter)
//
//
//    val days = ChronoUnit.DAYS.between(postDateTime, now)
//    val hours = ChronoUnit.HOURS.between(postDateTime, now)
//    val minutes = ChronoUnit.MINUTES.between(postDateTime, now)
//    val seconds = ChronoUnit.SECONDS.between(postDateTime, now)
//
//
//    val ago:Long
//    if (days > 0)
//        ago=days
//    else if (hours > 0)
//        ago=hours
//    else if (minutes > 0)
//        ago=minutes
//    else if (seconds > 0)
//        ago=seconds
//    else
//        ago=0


    var clicked by remember {
        mutableStateOf(1)
    }
    
    Spacer(modifier = Modifier.height(20.dp))

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth(.9f)
            .wrapContentHeight(),
        colors = androidx.compose.material3.CardDefaults.cardColors(
            containerColor = Color(0xFF314957),

            )
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically // Center all elements vertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {

                    Spacer(modifier = Modifier.width(10.dp))

                    Column {
                        Text(
                            text = "${tweet.authorName}", color = Color.White,
                            fontFamily = Comissioner,
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Text(
                            fontFamily = Comissioner,
                            text = "@${tweet.author}",
                            color = Color.White,
                            style = TextStyle(
                                fontSize = 12.sp
                            )
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))

                }

              
                Box(modifier = Modifier){
                    when(tweet.domain){
                        "ML"-> MLChip()
                        "iot"-> AndroidChip()
                        "Android"-> AndroidChip()
                        "Web" -> WebChip()
                        "AR/VR"-> ARVRChip()
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                fontFamily = Comissioner,
                text = tweet.content,
                color = Color(0xffffffff),
                modifier = Modifier.padding(start = 60.dp, end = 30.dp),
                style = TextStyle(
                    fontSize = 16.sp, fontWeight = FontWeight.SemiBold
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.padding(start = 20.dp, end = 30.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
//                 Group 1: Time
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(2f) // Ensures equal spacing
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_access_time_filled_24),
                        contentDescription = "like",
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        fontFamily = Comissioner,
                        text = "${tweet.time}",
                        color = Color(0xff8E9599),
                        style = TextStyle(
                            fontSize = 12.sp, fontWeight = FontWeight.SemiBold
                        )
                    )

                }

                // Group 2: Number of Applicants
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(2f)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.comments),
                        contentDescription = "comments",
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        fontFamily = Comissioner,
                        text = " ${tweet.applications.size.toString()}",
                        color = Color(0xFFB6B6B6)
                    )

                }

//                // Group 3: Repost
//                Row(
//                    verticalAlignment = Alignment.CenterVertically,
//                    modifier = Modifier.weight(1f)
//                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.repost),
//                        contentDescription = "repost",
//                        modifier = Modifier.size(16.dp)
//                    )
//                    Text(
//                        text = "2",
//                        color = Color(0xff8E9599),
//                        style = TextStyle(
//                            fontSize = 12.sp,
//                            fontWeight = FontWeight.SemiBold
//                        ),
//                        modifier = Modifier.padding(start = 5.dp)
//                    )
//                }

//                 Group 4: Apply Button
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .width(42.dp)
                        .height(30.dp)
                        .clip(RoundedCornerShape(2.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = {
                            clicked = 0
                            tweetViewModel.application(tweet.id)
                        },
                        colors = ButtonDefaults.buttonColors(Color(0xFF5EE45B)),
                        enabled = !tweet.applications.contains(currentUserId) && (clicked == 1),
                        modifier = Modifier.padding(
//                            start = 10.dp,
                            horizontal = 10.dp,
                            vertical = 2.dp
                        ),
                    ) {
                        Text(
                            text = "Apply",
                            color = Color.White,
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }

        }
    }
    Spacer(modifier = Modifier.height(30.dp))
}
