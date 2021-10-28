package com.example.mvpapplication.ui.login

import com.example.mvpapplication.R
import com.example.mvpapplication.local_db.UserDao
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class LoginPresenter(val view: LoginContract.View, val userDao: UserDao) : LoginContract.Presenter, CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.IO

    override fun performLogin(user: String, password: String) {
        launch{
           val  userExist = userDao.checkUser(user,password)
            withContext(Dispatchers.Main) {
               if (userExist>0) {
                   view.onLoginSuccess()
               }else{
                   view.showError(R.string.user_does_not_found)
               }
            }
        }
    }

}