package com.template.testapp.domain.repository

import com.template.testapp.domain.models.SaveUsernameParam
import com.template.testapp.domain.models.Username

interface UserRepository {
    fun saveName(saveParam: SaveUsernameParam): Boolean

    fun getName(): Username
}