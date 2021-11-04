package com.template.testapp.di

import com.template.data.repository.UserRepositoryImpl
import com.template.data.storage.UserStorage
import com.template.data.storage.sharedPrefs.SharedPrefUserStorage
import com.template.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {
    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}