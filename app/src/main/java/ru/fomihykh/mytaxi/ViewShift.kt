package ru.fomihykh.mytaxi

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ViewShift(shift: Shift){
    Column(Modifier.padding(10.dp)
        .background(Color(0xFF004C69))
        .padding(10.dp)
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Column(modifier = Modifier.weight(0.3f)) {
                Row {
                    Text(
                        "Время:",
                        fontSize = 15.sp,
                        color = Color.White,
                        textAlign = TextAlign.Start
                    )
                    Text(
                        shift.timeShift.toString(), fontSize = 15.sp, color = Color.White,
                        textAlign = TextAlign.End,
                    )
                }
                Row {
                    Text(
                        "Пробег:",
                        fontSize = 15.sp,
                        color = Color.White,
                        textAlign = TextAlign.Start
                    )
                    Text(
                        (shift.mileage).toString(), fontSize = 15.sp, color = Color.White,
                        textAlign = TextAlign.End
                    )
                }
                Row {
                    Text(
                        "Прибыль:",
                        fontSize = 15.sp,
                        color = Color.White,
                        textAlign = TextAlign.Start
                    )
                    Text(
                        shift.profit.toString(), fontSize = 15.sp, color = Color.White,
                        textAlign = TextAlign.End
                    )
                }
                Row {
                    Text(
                        "Дата:",
                        fontSize = 15.sp,
                        color = Color.White,
                        textAlign = TextAlign.Start
                    )
                    Text(
                        (shift.dateStart).toString(), fontSize = 15.sp, color = Color.White,
                    )
                }
            }
            Column(modifier = Modifier.weight(0.3f)) {
                Text("Старт смены", fontSize = 10.sp, color = Color.White)
                Row {
                    Text("Наличные:", fontSize = 10.sp, color = Color.White)
                    Text(shift.cashStart.toString(), fontSize = 10.sp, color = Color.White)
                }
                Row {
                    Text("Безналичные:", fontSize = 10.sp, color = Color.White)
                    Text(shift.noncashStart.toString(), fontSize = 10.sp, color = Color.White)
                }
                Row {
                    Text("Таксопарк:", fontSize = 10.sp, color = Color.White)
                    Text(shift.noncashtaxiStart.toString(), fontSize = 10.sp, color = Color.White)
                }
                Row {
                    Text("Пробег:", fontSize = 10.sp, color = Color.White)
                    Text(shift.mileageStart.toString(), fontSize = 10.sp, color = Color.White)
                }
            }
            Column(modifier = Modifier.weight(0.3f)) {
                Text("Конец смены", fontSize = 15.sp, color = Color.White)
                Row {
                    Text("Наличные:", fontSize = 15.sp, color = Color.White)
                    Text(shift.cashEnd.toString(), fontSize = 15.sp, color = Color.White)
                }
                Row {
                    Text("Безналичные:", fontSize = 15.sp, color = Color.White)
                    Text(shift.noncashEnd.toString(), fontSize = 15.sp, color = Color.White)
                }
                Row {
                    Text("Таксопарк:", fontSize = 15.sp, color = Color.White)
                    Text(shift.noncashtaxiEnd.toString(), fontSize = 15.sp, color = Color.White)
                }
                Row {
                    Text("Пробег:", fontSize = 15.sp, color = Color.White)
                    Text(shift.mileageEnd.toString(), fontSize = 15.sp, color = Color.White)
                }
            }

        }
        Text("Коментарий:", fontSize = 15.sp, color = Color.White, textAlign = TextAlign.Start)
        Text(shift.comment, fontSize = 15.sp, color = Color.White, textAlign = TextAlign.Center)
    }
}