package ru.fomihykh.mytaxi

import android.content.SharedPreferences
import android.os.Build
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import java.nio.file.WatchEvent
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.Duration


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CloseShift(vm: ShiftViewModel,pref: SharedPreferences){
    var prefEditor = pref.edit()
    val dateStart = pref.getString("dateStart","")
    val cashStart = pref.getInt("cashStart",0)
    val noncashStart = pref.getInt("noncashStart",0)
    val noncashtaxiStart = pref.getInt("noncashtaxiStart",0)
    val mileageStart = pref.getInt("mileageStart",0)
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        OutlinedTextField(
            value = vm.cashEnd,
            onValueChange = { vm.cashEnd = it },
            textStyle = TextStyle(fontSize = 30.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("Наличные: ") },
            colors = TextFieldDefaults.colors(
                Color.White
            )
        )
        OutlinedTextField(
            value = vm.noncashEnd,
            onValueChange = { vm.noncashEnd = it },
            textStyle = TextStyle(fontSize = 30.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("Безналичные: ") },
            colors = TextFieldDefaults.colors(
                Color.White
            )
        )
        OutlinedTextField(
            value = vm.noncashtaxiEnd,
            onValueChange = { vm.noncashtaxiEnd = it },
            textStyle = TextStyle(fontSize = 30.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("Таксопарк: ") },
            colors = TextFieldDefaults.colors(
                Color.White
            )
        )
        OutlinedTextField(
            value = vm.mileageEnd,
            onValueChange = { vm.mileageEnd = it },
            textStyle = TextStyle(fontSize = 30.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("Пробег: ") },
            colors = TextFieldDefaults.colors(
                Color.White
            )
        )
        OutlinedTextField(
            value = vm.comment,
            onValueChange = { vm.comment = it },
            textStyle = TextStyle(fontSize = 30.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text("Комментарий: ") },
            colors = TextFieldDefaults.colors(
                Color.White
            )
        )
        val cur = LocalDateTime.now()
        val fort = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")
        val forTime = cur.format(fort)
        val startDataT = parseDateTime(dateStart.toString())
        val dur = getTimeDifference(startDataT,cur)
        Text(forTime.toString())
        Text(startDataT.toString())
        Text(dur.toString())
        Button(
            {
                val currentDateTime = LocalDateTime.now()
                val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")
                val formattedDateTime = currentDateTime.format(formatter)
                val mileage = vm.mileageEnd.toInt()-mileageStart
                val profit = vm.cashEnd.toInt()+vm.noncashEnd.toInt()+vm.noncashtaxiEnd.toInt()-
                        cashStart-noncashStart-noncashtaxiStart
                val startDataTime = parseDateTime(dateStart.toString())
                val duration = getTimeDifference(startDataTime,currentDateTime)

                vm.addShift(
                    shift = Shift(
                        dateStart = dateStart.toString(),
                        dateEnd = formattedDateTime,
                        cashStart = cashStart,
                        noncashStart = noncashStart,
                        noncashtaxiStart = noncashtaxiStart,
                        cashEnd = vm.cashEnd.toInt(),
                        noncashEnd = vm.noncashEnd.toInt(),
                        noncashtaxiEnd = vm.noncashtaxiEnd.toInt(),
                        mileage = mileage,
                        mileageStart = mileageStart,
                        mileageEnd = vm.mileageEnd.toInt(),
                        profit = profit,
                        timeShift = duration.toInt(),
                        comment = vm.comment,
                        open = false
                    )
                )
                prefEditor.putBoolean("open",false)
                prefEditor.apply()
                vm.selectedMenu = MenuList.LISTSHIFT
                vm.open = false
            }

        ) { Text("Зыкрыть смену") }
    }
}
@RequiresApi(Build.VERSION_CODES.O)
fun parseDateTime(dateTimeString: String): LocalDateTime {
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")
    return LocalDateTime.parse(dateTimeString, formatter)
}
@RequiresApi(Build.VERSION_CODES.O)
fun getTimeDifference(start: LocalDateTime, end: LocalDateTime): Long{
    val duration = Duration.between(start,end)
    val minutes = duration.toMinutes()
    return minutes
}