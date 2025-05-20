package ru.fomihykh.mytaxi

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Shifts")
class Shift {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
    //Date
    var time: Int = 0
    var dateStart: String = "" //Date at the start of the shift
    var dateEnd: String = "" // Date at the end of the shift
    //Finance
    var cashStart: Int = 0 //Cash at the beginning of the shift
    var noncashStart: Int = 0 //Cashless payments at the beginning of the shift
    var noncashtaxiStart: Int = 0 //On the taxi company's account at the beginning of the shift

    var cashEnd: Int = 0 //Cash at the end of the shift
    var noncashEnd: Int = 0 //Cashless payments at the end of the shift
    var noncashtaxiEnd: Int = 0 //On the taxi company's account at the end of the shift

    var mileage: Int = 0
    var mileageStart: Int = 0 //Mileage at the start of the shift
    var mileageEnd: Int = 0 //Mileage at the end of the shift

    var profit: Int = 0 //Profit at the end of the shift
    var timeShift: Int = 0 // Shift time in seconds
    var comment: String = "" //Comment at the end shift

    var open: Boolean = true



    constructor(){}

    constructor(
        dateStart: String,
        dateEnd: String,
        cashStart: Int,
        noncashStart: Int,
        noncashtaxiStart: Int,
        cashEnd: Int,
        noncashEnd: Int,
        noncashtaxiEnd: Int,
        mileage: Int,
        mileageStart: Int,
        mileageEnd: Int,
        profit: Int,
        timeShift: Int,
        comment: String,
        open: Boolean
    ) {
        this.dateStart = dateStart
        this.dateEnd = dateEnd
        this.cashStart = cashStart
        this.noncashStart = noncashStart
        this.noncashtaxiStart = noncashtaxiStart
        this.cashEnd = cashEnd
        this.noncashEnd = noncashEnd
        this.noncashtaxiEnd = noncashtaxiEnd
        this.mileage = mileage
        this.mileageStart = mileageStart
        this.mileageEnd = mileageEnd
        this.profit = profit
        this.timeShift = timeShift
        this.comment = comment
        this.open = open
    }
}