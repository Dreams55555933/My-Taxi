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
}