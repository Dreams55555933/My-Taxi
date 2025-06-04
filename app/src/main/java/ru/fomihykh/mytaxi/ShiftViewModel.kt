package ru.fomihykh.mytaxi

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class ShiftViewModel(application: Application): ViewModel() {

    var selectedMenu by mutableStateOf(MenuList.STATISTIC)

    val shiftList: LiveData<List<Shift>>
    private val repository: ShiftRepository

    var selectedViewShift by mutableStateOf(Shift())
    var dateStart by mutableStateOf("") //Date at the start of the shift
    var dateEnd by mutableStateOf("") // Date at the end of the shift
    //Finance
    var cashStart by mutableStateOf("") //Cash at the beginning of the shift
    var noncashStart by mutableStateOf("") //Cashless payments at the beginning of the shift
    var noncashtaxiStart by mutableStateOf("") //On the taxi company's account at the beginning of the shift

    var cashEnd by mutableStateOf("") //Cash at the end of the shift
    var noncashEnd by mutableStateOf("") //Cashless payments at the end of the shift
    var noncashtaxiEnd by mutableStateOf("") //On the taxi company's account at the end of the shift

    var mileageStart  by mutableStateOf("") //Mileage at the start of the shift
    var mileageEnd  by mutableStateOf("") //Mileage at the end of the shift

    var profit  by mutableStateOf("") //Profit at the end of the shift
    var timeShift  by mutableStateOf("") // Shift time in seconds
    var comment by mutableStateOf("") //Comment at the end shift

    var open: Boolean by mutableStateOf(false)
    var deleteShift by mutableStateOf(Shift())
    var openDialog by mutableStateOf(false)

    init {
        val shiftDb = ShiftRoomDatabase.getInstance(application)
        val shiftDao = shiftDb.shiftDao()
        repository = ShiftRepository(shiftDao)
        shiftList = repository.shiftList
    }

    fun addShift(shift: Shift){
        repository.addShift(shift)
    }
    fun deleteShift(shift: Shift){
        repository.deleteShift(shift)
    }
}