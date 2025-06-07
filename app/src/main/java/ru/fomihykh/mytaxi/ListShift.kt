package ru.fomihykh.mytaxi

import android.R
import android.text.Layout
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData

@Composable
fun ListShift(vm: ShiftViewModel, shifts: LiveData<List<Shift>>){
    val shiftList by shifts.observeAsState(listOf())

    LazyColumn {
        items(shiftList) { shift->
            Column(
                Modifier.padding(10.dp)
                    .background(Color(0xFF004C69), shape = RoundedCornerShape(20.dp))
                    .padding(10.dp)
                    .fillMaxWidth()
                    .height(60.dp)
                    .clickable{
                        vm.selectedMenu = MenuList.VIEWSHIFT
                        vm.selectedViewShift = shift
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row {
                    Text("Дата: ",color = Color.White)
                    Text(shift.dateStart, color = Color.White)
                }
                Row {
                    Text("Прибыль: ",color = Color.White)
                    Text(shift.profit.toString(), color = Color.White)
                }

            }
        }
    }
}