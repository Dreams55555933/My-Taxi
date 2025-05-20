package ru.fomihykh.mytaxi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData

@Composable
fun ListShift(shifts: LiveData<List<Shift>>){
    val shiftList by shifts.observeAsState(listOf())

    LazyColumn {
        items(shiftList) { shift->
            Column(Modifier.padding(10.dp)
                .background(if (shift.open) Color(247,57,65) else Color(15,30,39), shape = RoundedCornerShape(20.dp))
                .padding(10.dp)
                .fillMaxWidth()
                .height(160.dp)) {
                Row {
                    Column(modifier = Modifier.fillMaxWidth(0.5f)) {
                        Text("Время:", fontSize = 10.sp, color = Color.White, textAlign = TextAlign.Start)
                        Text(
                            shift.time.toString(), fontSize = 10.sp, color = Color.White,
                            textAlign = TextAlign.End
                        )

                        Text("Пробег:", fontSize = 10.sp, color = Color.White, textAlign = TextAlign.Start)
                        Text(
                            (shift.mileage).toString(), fontSize = 10.sp, color = Color.White,
                            textAlign = TextAlign.End
                        )

                        Text("Прибыль:", fontSize = 10.sp, color = Color.White, textAlign = TextAlign.Start)
                        Text(
                            shift.profit.toString(), fontSize = 10.sp, color = Color.White,
                            textAlign = TextAlign.End
                        )

                        Text("Дата:", fontSize = 10.sp, color = Color.White, textAlign = TextAlign.Start)
                        Text(
                            (shift.dateStart).toString(), fontSize = 10.sp, color = Color.White,
                            textAlign = TextAlign.End
                        )

                    }
                    Column(modifier = Modifier.fillMaxWidth(0.5f)) {
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

                        Text("Конец смены", fontSize = 10.sp, color = Color.White)
                        Row {
                            Text("Наличные:", fontSize = 10.sp, color = Color.White)
                            Text(shift.cashEnd.toString(), fontSize = 10.sp, color = Color.White)
                        }
                        Row {
                            Text("Безналичные:", fontSize = 10.sp, color = Color.White)
                            Text(shift.noncashEnd.toString(), fontSize = 10.sp, color = Color.White)
                        }
                        Row {
                            Text("Таксопарк:", fontSize = 10.sp, color = Color.White)
                            Text(shift.noncashtaxiEnd.toString(), fontSize = 10.sp, color = Color.White)
                        }
                        Row {
                            Text("Пробег:", fontSize = 10.sp, color = Color.White)
                            Text(shift.mileageEnd.toString(), fontSize = 10.sp, color = Color.White)
                        }
                    }

                }
                Text(shift.comment, fontSize = 10.sp, color = Color.White)
            }
        }
    }
}