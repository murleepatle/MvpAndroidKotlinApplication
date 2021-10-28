package com.example.mvpapplication.ui.welcome

import com.example.mvpapplication.R
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class WelcomePresenter(val view: WelcomeContract.View) : WelcomeContract.Presenter, CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.IO
    override fun loadUserAndNavigate() {
       //Logic when login preference
        launch{
            Thread.sleep(2000)
            withContext(Dispatchers.Main) {
           view.goLoginPage()
           //if user detail is store navigate dashboard
           //view.goDashboard() //todo uncomment if you want to check it
           //if something went wrong just call
            //   view.showError(R.string.error_something_wrong) //todo uncomment if you want to check it
           }
        }


    }

}