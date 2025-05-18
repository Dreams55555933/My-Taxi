package ru.fomihykh.mytaxi

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(Shift::class)], version = 1)
abstract class ShiftRoomDatabase: RoomDatabase() {

    abstract fun shiftDao(): ShiftDao

    companion object{
        private var INSTANCE: ShiftRoomDatabase? = null
        fun getInstance(context: Context): ShiftRoomDatabase{
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ShiftRoomDatabase::class.java,
                        "shiftdb"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}