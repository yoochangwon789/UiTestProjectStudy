package com.example.uitestproject

import io.realm.RealmObject


open class School: RealmObject() {

    var name: String? = null

    var location: String? = null
}