package com.example.form.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(val name: String?, val lastName: String?, val age: Int?) : Parcelable