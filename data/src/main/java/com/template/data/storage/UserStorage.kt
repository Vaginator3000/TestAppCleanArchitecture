package com.template.data.storage

import com.template.data.storage.models.User

interface UserStorage {
    fun save(user: User): Boolean

    fun get(): User
}