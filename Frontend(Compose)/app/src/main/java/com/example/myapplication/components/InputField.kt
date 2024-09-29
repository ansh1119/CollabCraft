package com.example.myapplication.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
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

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier.height(50.dp),
        placeholder = {
            Text(text = label, fontSize = 12.sp, color = Color.Gray, fontWeight = FontWeight.Medium)
        }
    )

    Spacer(modifier = Modifier.height(15.dp))
}
