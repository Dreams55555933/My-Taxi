package ru.fomihykh.mytaxi

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Menu(){
    Box(
        Modifier.padding(10.dp)
            .background(Color(40,57,65), shape = RoundedCornerShape(20.dp))
            .padding(10.dp)
    ){
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(80,178,189)
                ),
                modifier = Modifier.weight(0.35f)
            ) {
                Text("Статистика")
            }
            IconButton({},
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color(80,178,189),
                    contentColor = Color.White
                ),
                modifier = Modifier.border(
                    shape = CircleShape, border = BorderStroke(width = 0.dp, color = Color.Black)
                ).size(50.dp)) {
                Icon(
                    Icons.Filled.Add, contentDescription = "Добавить",
                    modifier = Modifier.size(30.dp)
                )
            }
            Button(
                {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(80,178,189)
                ),
                modifier = Modifier.weight(0.35f)
            ) {
                Text("Список смен")
            }
        }
    }
}