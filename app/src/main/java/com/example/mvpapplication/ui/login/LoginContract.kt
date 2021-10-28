package com.example.mvpapplication.ui.login

interface LoginContract {
    /** Represents the View in MVP.  */
    interface View {
        fun onLoginSuccess()
        fun showError(error: Int)
    }

    /** Represents the Presenter in MVP.  */
    interface Presenter {
        fun performLogin(user:String,password:String)
    }
}