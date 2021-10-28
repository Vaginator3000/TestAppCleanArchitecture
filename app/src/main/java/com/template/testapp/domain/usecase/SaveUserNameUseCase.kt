package com.template.testapp.domain.usecase

import com.template.testapp.domain.models.SaveUsernameParam
import com.template.testapp.domain.models.Username
import com.template.testapp.domain.repository.UserRepository
import java.util.Random

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUsernameParam): Boolean {
        val oldUsername = userRepository.getName()
        if (oldUsername.name == param.name)
            return true

        return userRepository.saveName(saveParam = param)
    }
}