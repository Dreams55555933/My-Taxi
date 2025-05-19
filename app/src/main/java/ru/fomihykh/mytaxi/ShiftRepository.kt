package ru.fomihykh.mytaxi

import androidx.compose.foundation.text.selection.DisableSelection
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShiftRepository(val shiftDao: ShiftDao) {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    val shiftList: LiveData<List<Shift>> = shiftDao.getShifts()

    fun addShift(shift: Shift) = coroutineScope.launch { shiftDao.addShift(shift) }

    fun deleteShift(shift: Shift) = coroutineScope.launch { shiftDao.deleteShift(shift) }
}