package ru.fomihykh.mytaxi

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class ShiftViewModel(application: Application): ViewModel() {

    val selectedMenu by mutableStateOf(MenuList.STATISTIC)

    val shiftList: LiveData<List<Shift>>
    private val repository: ShiftRepository


    var dateStart by mutableStateOf("") //Date at the start of the shift
    var dateEnd by mutableStateOf("") // Date at the end of the shift
    //Finance
    var cashStart by mutableIntStateOf(0) //Cash at the beginning of the shift
    var noncashStart by mutableIntStateOf(0) //Cashless payments at the beginning of the shift
    var noncashtaxiStart by mutableIntStateOf(0) //On the taxi company's account at the beginning of the shift

    var cashEnd by mutableIntStateOf(0) //Cash at the end of the shift
    var noncashEnd by mutableIntStateOf(0) //Cashless payments at the end of the shift
    var noncashtaxiEnd by mutableIntStateOf(0) //On the taxi company's account at the end of the shift

    var mileageStart  by mutableIntStateOf(0) //Mileage at the start of the shift
    var mileageEnd  by mutableIntStateOf(0) //Mileage at the end of the shift

    var profit: Int  by mutableIntStateOf(0) //Profit at the end of the shift
    var timeShift: Int  by mutableIntStateOf(0) // Shift time in seconds
    var comment by mutableStateOf("") //Comment at the end shift

    var open: Boolean by mutableStateOf(true)

    init {
        val shiftDb = ShiftRoomDatabase.getInstance(application)
        val shiftDao = shiftDb.shiftDao()
        repository = ShiftRepository(shiftDao)
        shiftList = repository.shiftList
    }

    fun addShift(shift: Shift){
        repository.addShift(shift)
    }
}