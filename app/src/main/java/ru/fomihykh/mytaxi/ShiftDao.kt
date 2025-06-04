package ru.fomihykh.mytaxi

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ShiftDao {
    @Query("SELECT * FROM shifts")
    fun getShifts(): LiveData<List<Shift>>

    @Query("SELECT * FROM  shifts WHERE id = :id")
    fun getByIdShift(id: Int): Shift

    @Insert
    fun addShift(shift: Shift)

    @Delete
    fun deleteShift(shift: Shift)

    @Query(
        "UPDATE shifts SET dateEnd = :dataEnd, cashEnd = :cashEnd, noncashEnd = :noncashEnd, " +
                "noncashtaxiEnd = :noncashtaxiEnd,mileage = :mileage, mileageEnd = :mileageEnd, " +
                "profit = :profit, timeShift = :timeShift, comment = :comment, open = :open " +
                "WHERE id = :id;"
    )
    fun closeShift(
        id: Int, dataEnd: String, cashEnd: Int, noncashEnd: Int, noncashtaxiEnd: Int, mileage: Int,
        mileageEnd: Int,profit: Int,timeShift: Int,comment: String,open: Boolean = false
    )
}