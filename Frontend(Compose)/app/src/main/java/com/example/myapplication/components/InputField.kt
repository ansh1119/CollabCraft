package com.example.myapplication.components

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun InputField(label: String, value: String, onValueChange: (String) -> Unit) {
    Row {
        Text(text = label, fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.SemiBold)
        if (label != "Second Domain (Optional)") {
            Text(text = " *", fontSize = 16.sp, color = Color.Red, fontWeight = FontWeight.SemiBold)
        }
    }

    Spacer(modifier = Modifier.height(10.dp))

    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.height(50.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            errorContainerColor = Color.Transparent
        ),
        placeholder = {
            Text(text = label,
                fontSize = 16.sp,
                color = Color(0xFF586B76),
                fontWeight = FontWeight.Medium)
        }
    )

    Spacer(modifier = Modifier.height(30.dp))
}

@Preview
@Composable
fun InputFieldPreview(){
    InputField(label = "username", value = "hello") {
        Log.d("h","dskfjads")
    }
}
