package com.template.domain.usecase

import com.template.domain.models.SaveUsernameParam
import com.template.domain.repository.UserRepository


class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUsernameParam): Boolean {
        val oldUsername = userRepository.getName()
        if (param.name == oldUsername.name)
            return true

        return userRepository.saveName(saveParam = param)
    }
}