package com.template.domain.usecase

import com.template.domain.models.Username
import com.template.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): Username {
        return userRepository.getName()
    }
}