import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.Components.InputField

@Composable
fun SignUp2Screen(onNavigateBack: () -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var cnfPass by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF1D2A32)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.fillMaxSize()) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "One last step to set \nup your account.",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 20.dp, top = 80.dp)
                )

                Card(
                    colors = CardDefaults.cardColors(containerColor = Color(0xff314957)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp, top = 60.dp)
                ) {
                    Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)) {
                        InputField(label = "Name", value = username, onValueChange = { username = it })
                        InputField(label = "Enter Your Password", value = password, onValueChange = { password = it })
                        InputField(label = "Confirm Your Password", value = cnfPass, onValueChange = { cnfPass = it })

                        Button(
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .fillMaxWidth(.8f)
                                .align(Alignment.CenterHorizontally)
                                .shadow(
                                    elevation = 10.dp,
                                    spotColor = Color(0xFF00E0FF),
                                    ambientColor = Color.White,
                                    shape = RoundedCornerShape(28.dp)
                                ),
                            shape = RoundedCornerShape(28.dp),
                            colors = ButtonDefaults.buttonColors(Color(0xFF00E0FF)),
                            onClick = {  }
                        ) {
                            Text(text = "Sign In")
                        }

                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
            }

            // Left arrow on SignUp2 screen (non-functional)
            IconButton(
                onClick = {},
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(end = 6.dp)
                    .background(color = Color(0xff586B76), shape = CircleShape)  // Optional background color
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "Previous",
                    tint = Color(0xff00E0FF)
                )
            }

            // Right arrow on SignUp2 screen (non-functional)
            IconButton(
                onClick = {},
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 6.dp)
                    .background(color = Color(0xff586B76), shape = CircleShape)  // Optional background color
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowRight,
                    contentDescription = "Next",
                    tint = Color(0xff00E0FF)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSignUp2Screen() {
    SignUp2Screen(onNavigateBack = {})
}