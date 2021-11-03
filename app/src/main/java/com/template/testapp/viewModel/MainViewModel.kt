package com.template.testapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.template.domain.models.SaveUsernameParam
import com.template.domain.usecase.GetUserNameUseCase
import com.template.domain.usecase.SaveUserNameUseCase

class MainViewModel(
        private val getUserNameUseCase: GetUserNameUseCase,
        private val saveUserNameUseCase: SaveUserNameUseCase
    ) : ViewModel() {

    private var resultLiveMutable = MutableLiveData<String>()
    var resultLive: LiveData<String> = resultLiveMutable

    fun saveData(data: String) {
        val params = SaveUsernameParam(data)
        val result = saveUserNameUseCase.execute(param = params)
        resultLiveMutable.value = "save result - $result"
    }

    fun getData() {
        val userName = getUserNameUseCase.execute()
        resultLiveMutable.value = "${userName.name} - ${userName.surname}"
    }
}