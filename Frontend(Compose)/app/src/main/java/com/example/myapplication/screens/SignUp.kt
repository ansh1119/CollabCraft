import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.components.InputField

@Composable
fun SignUp(navController: NavController) {

    val Comissioner = FontFamily(
        Font(R.font.comissioner)
    )


    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var cnfPass by remember { mutableStateOf("") }


    Box(modifier = Modifier.fillMaxSize()) {


        Image(modifier= Modifier
            .fillMaxSize()
            .scale(1.2f),
            painter = painterResource(id = R.drawable.signupbg),
            contentDescription = "")


        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text ="Create Your Account." ,
                color = Color.White,
                fontFamily = Comissioner,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 36.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 80.dp)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(30.dp))
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xff314957)),
                modifier = Modifier
                    .fillMaxWidth(.9f)
                    .padding(start = 20.dp, end = 20.dp, top = 60.dp)
            ) {
                Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)) {
                    InputField(
                        label = "Name",
                        value = username,
                        onValueChange = { username = it })
                    InputField(
                        label = "Enter Your Password",
                        value = password,
                        onValueChange = { password = it })
                    InputField(
                        label = "Confirm Your Password",
                        value = cnfPass,
                        onValueChange = { cnfPass = it })

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
                            onClick = { }
                        ) {
                            Text(text = "Sign In")
                        }

                        Spacer(modifier = Modifier.height(20.dp))


                    }

                }

            Spacer(modifier = Modifier.height(60.dp))
            Row {
                Spacer(modifier = Modifier.weight(.1f))
                Card(
                    modifier = Modifier.weight(.8f),
                    colors = CardDefaults.cardColors(Color(0xFF314957))
                ) {
                    Row(
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Already have an account?",
                            color = Color.White
                        )
                        Text(
                            modifier=Modifier.clickable {
                                navController.navigate(route = "Login")
                            },
                            text = "Sign Up",
                            color = Color(0xFF00E0FF)
                        )
                    }
                }
                Spacer(modifier = Modifier.weight(.1f))
            }

            }

            // Right arrow on SignUp2 screen (functional)
            IconButton(
                onClick = {navController.navigate(route = "sign-up-2/$username/$password")},
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 6.dp)
                    .background(
                        color = Color(0xff586B76),
                        shape = CircleShape
                    )  // Optional background color
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowRight,
                    contentDescription = "Next",
                    tint = Color(0xff00E0FF)
                )
            }
        }
}
