package ru.fomihykh.mytaxi

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query

@Dao
interface ShiftDao {
    @Query("SELECT * FROM shifts")
    fun getAll(): List<Shift>

    @Query("SELECT * FROM  shifts WHERE id = :id")
    fun getById(id: Int): Shift

    @Delete
    fun delete(shift: Shift)
}