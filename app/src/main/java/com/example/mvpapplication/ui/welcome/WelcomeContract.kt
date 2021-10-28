package com.example.mvpapplication.ui.welcome

interface WelcomeContract {
    /** Represents the View in MVP.  */
    interface View {
        fun goLoginPage()
        fun goDashboard()
        fun showError(error: Int)
    }

    /** Represents the Presenter in MVP.  */
    interface Presenter {
        fun loadUserAndNavigate()
    }
}