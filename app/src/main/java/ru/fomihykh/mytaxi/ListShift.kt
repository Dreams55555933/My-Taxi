package ru.fomihykh.mytaxi

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData

@Composable
fun ListShift(shifts: LiveData<List<Shift>>){
    val shiftList by shifts.observeAsState(listOf())

    LazyRow {
        items(shiftList) { shift->
            Text(shift.id.toString())
        }
    }
}