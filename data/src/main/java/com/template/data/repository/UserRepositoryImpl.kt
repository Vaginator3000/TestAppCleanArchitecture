package com.template.data.repository

import com.template.data.storage.models.User
import com.template.data.storage.UserStorage
import com.template.domain.models.SaveUsernameParam
import com.template.domain.models.Username
import com.template.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUsernameParam): Boolean {
        return userStorage.save(user = mapToDataStorage(saveParam = saveParam))
    }

    override fun getName(): Username {
        val user = userStorage.get()
        return mapToDomain(user = user)
    }

    private fun mapToDomain(user: User) =
        Username(name = user.name, surname = user.surname)


    private fun mapToDataStorage(saveParam: SaveUsernameParam) =
        User(name = saveParam.name, surname = "surname")

}