package com.bowoon.android.common.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

val gson = Gson()

inline fun <reified T> Gson.fromJson(json: String): T =
    this.fromJson(json, object : TypeToken<T>() {}.type)

inline fun <reified T> Context.readAssetsFile(name: String) =
    this.assets.open(name).bufferedReader().use {
        gson.fromJson<T>(it.readText())
    }