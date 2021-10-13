package com.example.ejercicio.entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class User( id : Int, name : String, password : String) :Parcelable {

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id : Int = id

    @ColumnInfo(name = "name")
    var name : String = name

    @ColumnInfo(name = "password")
    var password : String = password

    constructor(source: Parcel) : this(
        source.readInt()!!,
        source.readString()!!,
        source.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(password)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}