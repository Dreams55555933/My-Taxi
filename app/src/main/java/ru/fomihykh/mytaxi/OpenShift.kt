package ru.fomihykh.mytaxi

import android.content.SharedPreferences
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun OpenShift(vm: ShiftViewModel,pref: SharedPreferences){
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        OutlinedTextField(
            value = vm.cashStart,
            onValueChange = { vm.cashStart = it },
            textStyle = TextStyle(fontSize = 30.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("Наличные: ") },
            colors = TextFieldDefaults.colors(
                Color.White
            )
        )
        OutlinedTextField(
            value = vm.noncashStart,
            onValueChange = { vm.noncashStart = it },
            textStyle = TextStyle(fontSize = 30.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("Безналичные: ") },
            colors = TextFieldDefaults.colors(
                Color.White
            )
        )
        OutlinedTextField(
            value = vm.noncashtaxiStart,
            onValueChange = { vm.noncashtaxiStart = it },
            textStyle = TextStyle(fontSize = 30.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("Таксопарк: ") },
            colors = TextFieldDefaults.colors(
                Color.White
            )
        )
        OutlinedTextField(
            value = vm.mileageStart,
            onValueChange = { vm.mileageStart = it },
            textStyle = TextStyle(fontSize = 30.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("Пробег: ") },
            colors = TextFieldDefaults.colors(
                Color.White
            )
        )
        Button(
            { open(vm,pref) }
        ) { Text("Открыть смену") }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun open(vm: ShiftViewModel, pref: SharedPreferences){
    var prefEditor = pref.edit()
    val currentDateTime = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")
    val formattedDateTime = currentDateTime.format(formatter)
    prefEditor.putBoolean("open",true)
    prefEditor.putString("dateStart" ,formattedDateTime)
    prefEditor.putInt("cashStart",vm.cashStart.toInt())
    prefEditor.putInt("noncashStart",vm.noncashStart.toInt())
    prefEditor.putInt("noncashtaxiStart",vm.noncashtaxiStart.toInt())
    prefEditor.putInt("mileageStart",vm.mileageStart.toInt())
    prefEditor.apply()
    vm.selectedMenu = MenuList.STATISTIC
    vm.open = true
}