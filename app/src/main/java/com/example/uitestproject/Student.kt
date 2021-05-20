package com.example.uitestproject

import java.io.Serializable

class Student(
    var id: Int? = null,
    var name: String? = null,
    var age: Int? = null,
    var intro: String? = null
): Serializable