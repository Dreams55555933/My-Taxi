package ru.fomihykh.mytaxi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ViewShift(vm: ShiftViewModel){
    var shift = vm.selectedViewShift
    Column(Modifier.padding(10.dp)
        .background(Color(0xFF004C69))
        .padding(10.dp)
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            StartShiftInfo(shift)
            EndShiftInfo(shift)

        }
        Spacer(Modifier.height(20.dp))
        Row {

            CommonLeftInfo(shift)
            CommonRightInfo(shift)
        }
        Spacer(Modifier.height(20.dp))
        CommonBottomInfo(shift, vm)
    }
    AlertDeleteShift(vm)
}

@Composable
private fun AlertDeleteShift(vm: ShiftViewModel) {
    if (vm.openDialog) {
        AlertDialog(
            onDismissRequest = { vm.openDialog = false },
            title = { Text("Подтверждеие действия") },
            confirmButton = {
                Button(
                    onClick = {
                        vm.openDialog = false
                        vm.deleteShift(vm.deleteShift)
                        vm.selectedMenu = MenuList.LISTSHIFT
                    }
                ) { Text("Удалить") }
            },
            dismissButton = {
                Button(
                    onClick = { vm.openDialog = false }
                ) { Text("Отмена") }
            },
            containerColor = Color.White,
            titleContentColor = Color.Black,
            textContentColor = Color.Black,
            iconContentColor = Color.Black
        )
    }
}

@Composable
private fun CommonBottomInfo(shift: Shift, vm: ShiftViewModel) {
    Text("Коментарий:", fontSize = 15.sp, color = Color.White, textAlign = TextAlign.Start)
    Text(shift.comment, fontSize = 15.sp, color = Color.White, textAlign = TextAlign.Center)
    Button(
        onClick = {
            vm.deleteShift = shift
            vm.openDialog = true
        }
    ) { Text("Удалить") }
}

@Composable
private fun RowScope.CommonRightInfo(shift: Shift) {
    Column(modifier = Modifier.weight(0.5f), horizontalAlignment = Alignment.CenterHorizontally) {
        Row {
            Text(
                "Прибыль в час:",
                fontSize = 15.sp,
                color = Color.White,
                textAlign = TextAlign.Start
            )
            Text(
                "${if (shift.timeShift != 0) shift.profit / shift.timeShift * 60 else shift.profit / 1}",
                fontSize = 15.sp, color = Color.White,
                textAlign = TextAlign.End,
            )
        }
        Row {
            Text(
                "Прибыль на км:",
                fontSize = 15.sp,
                color = Color.White,
                textAlign = TextAlign.Start
            )
            Text(
                (if (shift.mileage != 0) shift.profit / shift.mileage else 0).toString(),
                fontSize = 15.sp,
                color = Color.White,
            )
        }
        Row {
            Text(
                "Прибыль:",
                fontSize = 15.sp,
                color = Color.White,
            )
            Text(
                shift.profit.toString(), fontSize = 15.sp, color = Color.White,
            )
        }
    }
}

@Composable
private fun RowScope.CommonLeftInfo(shift: Shift) {
    Column(modifier = Modifier.weight(0.5f), horizontalAlignment = Alignment.CenterHorizontally) {
        Row {
            Text(
                "Время:",
                fontSize = 15.sp,
                color = Color.White,
                textAlign = TextAlign.Start
            )
            Text(
                "${shift.timeShift / 60} : ${if (shift.timeShift!=0) shift.timeShift % 60 else 1}",
                fontSize = 15.sp, color = Color.White,
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
    }
}

@Composable
private fun RowScope.EndShiftInfo(shift: Shift) {
    Column(modifier = Modifier.weight(0.5f), horizontalAlignment = Alignment.CenterHorizontally) {
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
        Text(
            "Дата:",
            fontSize = 15.sp,
            color = Color.White,
        )
        Text(
            (shift.dateEnd).toString(), fontSize = 15.sp, color = Color.White,
        )
    }
}

@Composable
private fun RowScope.StartShiftInfo(shift: Shift) {
    Column(modifier = Modifier.weight(0.5f), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Старт смены", fontSize = 15.sp, color = Color.White)
        Row {
            Text("Наличные:", fontSize = 15.sp, color = Color.White)
            Text(shift.cashStart.toString(), fontSize = 15.sp, color = Color.White)
        }
        Row {
            Text("Безналичные:", fontSize = 15.sp, color = Color.White)
            Text(shift.noncashStart.toString(), fontSize = 15.sp, color = Color.White)
        }
        Row {
            Text("Таксопарк:", fontSize = 15.sp, color = Color.White)
            Text(shift.noncashtaxiStart.toString(), fontSize = 15.sp, color = Color.White)
        }
        Row {
            Text("Пробег:", fontSize = 15.sp, color = Color.White)
            Text(shift.mileageStart.toString(), fontSize = 15.sp, color = Color.White)
        }
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