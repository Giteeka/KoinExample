package com.app.koinexample.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User {

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
    var dob: Int? = null
    var phone: String? = null
    var cell: String? = null

    @Embedded
    var picture: Picture? = null

    var nat: String? = null
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
