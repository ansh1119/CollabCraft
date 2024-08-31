package com.example.myapplication.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@Composable
@Preview
fun Tweet() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        colors = androidx.compose.material3.CardDefaults.cardColors(
            containerColor = Color(0xFF1D2A32)
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
                    Image(
                        painter = painterResource(R.drawable.dp),
                        contentDescription = "avatar",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color.Gray, CircleShape)
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = "@ARYAN_MISHRA", color = Color.White, style = TextStyle(
                            fontSize = 13.sp, fontWeight = FontWeight.SemiBold
                        )
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "7 hr. ago", color = Color(0xff8E9599), style = TextStyle(
                            fontSize = 8.sp, fontWeight = FontWeight.SemiBold
                        )
                    )
                }

                Image(
                    painter = painterResource(R.drawable.menu),
                    contentDescription = "menu icon",
                    modifier = Modifier
                        .size(24.dp)
                        .padding(end = 10.dp) // Add padding if needed
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "need 2 members in my team for  HACKCBS. Interested ones, share ur details(name, year, branch and domain) in the thread.",
                color = Color(0xffffffff),
                modifier = Modifier.padding(start = 60.dp, end = 30.dp),
                style = TextStyle(
                    fontSize = 13.sp, fontWeight = FontWeight.SemiBold
                )
            )

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier.padding(start = 60.dp, end = 30.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Group 1: Like
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f) // Ensures equal spacing
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.like),
                        contentDescription = "like",
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = "2",
                        color = Color(0xff8E9599),
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        ),
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }

                // Group 2: Comments
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.comments),
                        contentDescription = "comments",
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = "2",
                        color = Color(0xff8E9599),
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        ),
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }

                // Group 3: Repost
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.repost),
                        contentDescription = "repost",
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = "2",
                        color = Color(0xff8E9599),
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        ),
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }

                // Group 4: Apply Button
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .width(42.dp)
                        .height(17.dp)
                        .clip(RoundedCornerShape(6.5.dp))
                        .background(Color(0xFF4CAF50)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "APPLY",
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 10.sp,
                            fontWeight = FontWeight.SemiBold
                        ),
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                    )
                }
            }

        }
    }
}
