package com.example.project

import android.os.Parcel
import android.os.Parcelable

class TipoMedicina(var nombreTipMed:String?):Parcelable{
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombreTipMed)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TipoMedicina> {
        override fun createFromParcel(parcel: Parcel): TipoMedicina {
            return TipoMedicina(parcel)
        }

        override fun newArray(size: Int): Array<TipoMedicina?> {
            return arrayOfNulls(size)
        }
    }

}