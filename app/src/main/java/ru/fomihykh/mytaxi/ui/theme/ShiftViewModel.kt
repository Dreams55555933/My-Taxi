package ru.fomihykh.mytaxi.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import ru.fomihykh.mytaxi.MenuList

class ShiftViewModel: ViewModel() {
    val selectedMenu by mutableStateOf(MenuList.STATISTIC)
}