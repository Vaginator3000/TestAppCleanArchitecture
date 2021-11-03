package com.template.testapp.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.template.data.repository.UserRepositoryImpl
import com.template.data.storage.sharedPrefs.SharedPrefUserStorage
import com.template.domain.usecase.GetUserNameUseCase
import com.template.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    private val userRepository by lazy(LazyThreadSafetyMode.NONE) { UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = context)) }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { GetUserNameUseCase(userRepository = userRepository) }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { SaveUserNameUseCase(userRepository = userRepository) }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(getUserNameUseCase = getUserNameUseCase, saveUserNameUseCase = saveUserNameUseCase) as T
    }
}