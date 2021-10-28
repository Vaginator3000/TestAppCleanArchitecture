package com.template.testapp.presentation

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.template.testapp.R
import com.template.testapp.data.repository.UserRepositoryImpl
import com.template.testapp.domain.models.SaveUsernameParam
import com.template.testapp.domain.usecase.GetUserNameUseCase
import com.template.testapp.domain.usecase.SaveUserNameUseCase
import com.template.testapp.viewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    //  private val viewBinding:  by viewBinding(R.id.container)
    //  private val viewBinding by viewBinding(Bindi ::bind, R.id.container)
    private val userRepository by lazy(LazyThreadSafetyMode.NONE) { UserRepositoryImpl(context = applicationContext) }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { GetUserNameUseCase(userRepository = userRepository) }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { SaveUserNameUseCase(userRepository = userRepository) }

    private val vModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }

    override fun onResume() {
        super.onResume()
        setOnClicks()
    }

    private fun setOnClicks() {
        saveNameBtn.setOnClickListener {
            val text = nameEditText.text.toString()
            val params = SaveUsernameParam(text)
            val result = saveUserNameUseCase.execute(param = params)
            dataTextView.text = result.toString()
        }

        getNameBtn.setOnClickListener {
            val userName = getUserNameUseCase.execute()
            dataTextView.text = "${userName.name} - ${userName.surname}"
        }
    }

}