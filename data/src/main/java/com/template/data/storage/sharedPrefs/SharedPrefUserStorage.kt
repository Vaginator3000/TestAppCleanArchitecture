package com.template.data.storage.sharedPrefs

import android.content.Context
import com.template.data.storage.UserStorage
import com.template.data.storage.models.User

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_NAME = "name"
private const val KEY_SURNAME = "surname"
private const val DEFAULT_NAME = "def_name"
private const val DEFAULT_SURNAME = "def_surname"

class SharedPrefUserStorage(context: Context) : UserStorage {
    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_NAME, user.name).apply()
        sharedPreferences.edit().putString(KEY_SURNAME, user.surname).apply()
        return true
    }

    override fun get(): User {
        val firstName = sharedPreferences.getString(KEY_NAME, DEFAULT_NAME) ?: DEFAULT_NAME
        val surName = sharedPreferences.getString(KEY_SURNAME, DEFAULT_SURNAME) ?: DEFAULT_SURNAME
        return User(name = firstName, surname = surName)
    }
}