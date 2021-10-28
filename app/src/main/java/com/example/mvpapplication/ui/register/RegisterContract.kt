package com.example.mvpapplication.ui.register

interface RegisterContract {
    /** Represents the View in MVP.  */
    interface View {
        fun onRegistrationComplete()
        fun showError(error: Int)
    }

    /** Represents the Presenter in MVP.  */
    interface Presenter {
        fun performRegistration(fullName:String,user:String,email:String,password:String,mobile:String,address:String)
    }
}