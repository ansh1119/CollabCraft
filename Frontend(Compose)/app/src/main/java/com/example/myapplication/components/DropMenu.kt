package com.example.myapplication.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@Composable
fun DropMenu(options: List<String>,
             selectedOption: String,
             onOptionSelected: (String) -> Unit) {

    var isDropDownExpanded by remember {
        mutableStateOf(false)
    }

    var itemPosition by remember {
        mutableStateOf(0)
    }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Box {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
                    isDropDownExpanded = true
                }
                    .upperBorder(10.dp,Color(0xFF00E0FF))
            ) {
                Text(text = options[itemPosition],
                    color = Color(0xFF00E0FF),
                    fontSize = 24.sp)
            }
            DropdownMenu(
                expanded = isDropDownExpanded,
                onDismissRequest = {
                    isDropDownExpanded = false
                }) {
                options.forEachIndexed { index, option ->
                    DropdownMenuItem(text = {
                        Text(text = option,
                            color = Color(0xFF00E0FF))
                    },
                        onClick = {
                            isDropDownExpanded = false
                            itemPosition = index
                            onOptionSelected(option)
                        })
                }
            }
        }

    }
}