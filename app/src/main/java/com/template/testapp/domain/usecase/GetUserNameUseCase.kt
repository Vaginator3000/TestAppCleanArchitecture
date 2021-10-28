package com.template.testapp.domain.usecase

import com.template.testapp.domain.models.Username
import com.template.testapp.domain.repository.UserRepository
import java.util.*

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): Username {
        return userRepository.getName()
    }
}