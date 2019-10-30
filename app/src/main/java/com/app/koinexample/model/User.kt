package com.app.koinexample.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User() : Parcelable {

    @PrimaryKey(autoGenerate = true)
//    var id: Long = 0
    var _ID: Long = 0

    var gender: String? = null

    @Embedded
    var name: Name? = null

    @Embedded
    var location: Location? = null
    var email: String? = null

    @Embedded
    var login: Login? = null

    var registered: Int? = null
    var dob: String? = null
    var phone: String? = null
    var cell: String? = null

    @Embedded
    var picture: Picture? = null

    var nat: String? = null

    constructor(parcel: Parcel) : this() {
        _ID = parcel.readLong()
        gender = parcel.readString()
        email = parcel.readString()
        registered = parcel.readValue(Int::class.java.classLoader) as? Int
        dob = parcel.readString()
        phone = parcel.readString()
        cell = parcel.readString()
        nat = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(_ID)
        parcel.writeString(gender)
        parcel.writeString(email)
        parcel.writeValue(registered)
        parcel.writeValue(dob)
        parcel.writeString(phone)
        parcel.writeString(cell)
        parcel.writeString(nat)
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


class Location {
    var street: String? = null
    var city: String? = null
    var state: String? = null
    var postcode: String? = null
}

class Login {
    var username: String? = null
    var password: String? = null
    var salt: String? = null
    var md5: String? = null
    var sha1: String? = null
    var sha256: String? = null
}

class Name {
    var title: String? = null
    var first: String? = null
    var last: String? = null
}

class Picture {
    var large: String? = null
    var medium: String? = null
    var thumbnail: String? = null
}
