package com.example.mvpapplication.ui.register

import com.example.mvpapplication.R
import com.example.mvpapplication.local_db.AppDatabase
import com.example.mvpapplication.local_db.UserDao
import com.example.mvpapplication.model.User
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class RegisterPresenter(val view: RegisterContract.View, val userDao: UserDao) : RegisterContract.Presenter, CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.IO

    override fun performRegistration(
        fullName: String,
        user: String,
        email: String,
        password: String,
        mobile: String,
        address: String
    ) {
        launch {
           val result = userDao.insert(User(username = user,name =fullName,email = email,password = password,mobile = mobile,address = address))
            withContext(Dispatchers.Main){
                if (result>0){
                    view.onRegistrationComplete()
                }else{
                    view.showError(R.string.error_on_register_user)
                }
            }

        }
    }

}