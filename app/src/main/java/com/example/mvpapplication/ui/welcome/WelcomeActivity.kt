package com.example.mvpapplication.ui.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvpapplication.R
import com.example.mvpapplication.ui.dashboard.MainActivity
import com.example.mvpapplication.ui.login.LoginActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class WelcomeActivity : AppCompatActivity() , WelcomeContract.View{

    lateinit var presenter: WelcomeContract.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        presenter= WelcomePresenter(this)
        presenter.loadUserAndNavigate()
        supportActionBar!!.hide()
    }


    override fun goLoginPage() {
        startActivity(Intent(this,LoginActivity::class.java))
        finish()
    }

    override fun goDashboard() {
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }

    override fun showError(error: Int) {
        MaterialAlertDialogBuilder(this)
            .setMessage(getString(error))
            .setPositiveButton("Exit") { dialog, which ->
                // Respond to positive button press
            }.show()
    }
}