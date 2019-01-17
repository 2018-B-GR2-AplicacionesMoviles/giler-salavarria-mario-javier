package com.example.project

import android.os.Parcel
import android.os.Parcelable

class Farmacia(var nombreFar:String?, var direccionFar:String?):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombreFar)
        parcel.writeString(direccionFar)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Farmacia> {
        override fun createFromParcel(parcel: Parcel): Farmacia {
            return Farmacia(parcel)
        }

        override fun newArray(size: Int): Array<Farmacia?> {
            return arrayOfNulls(size)
        }
    }

}