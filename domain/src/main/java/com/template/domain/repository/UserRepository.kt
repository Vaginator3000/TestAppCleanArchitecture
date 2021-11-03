package com.template.domain.repository

import com.template.domain.models.SaveUsernameParam
import com.template.domain.models.Username

interface UserRepository {
    fun saveName(saveParam: SaveUsernameParam): Boolean

    fun getName(): Username
}