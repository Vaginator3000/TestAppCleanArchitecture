package com.template.testapp.data.repository

import android.content.Context
import com.template.testapp.domain.models.SaveUsernameParam
import com.template.testapp.domain.models.Username
import com.template.testapp.domain.repository.UserRepository

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_NAME = "name"
private const val KEY_SURNAME = "surname"
private const val DEFAULT_NAME = "def_surname"

class UserRepositoryImpl(context: Context) : UserRepository {
    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveName(saveParam: SaveUsernameParam): Boolean {
        sharedPreferences.edit().putString(KEY_NAME, saveParam.name).apply()
        return true
    }

    override fun getName(): Username {
        val firstName = sharedPreferences.getString(KEY_NAME, "") ?: ""
        val surName = sharedPreferences.getString(KEY_SURNAME, DEFAULT_NAME) ?: DEFAULT_NAME
        return Username(name = firstName, surname = surName)
    }
}