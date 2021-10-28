package com.example.mvpapplication.ui.login

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mvpapplication.databinding.ActivityLoginBinding
import com.example.mvpapplication.local_db.AppDatabase
import com.example.mvpapplication.ui.dashboard.MainActivity
import com.example.mvpapplication.ui.register.RegistrationActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class LoginActivity : AppCompatActivity(),LoginContract.View {
    private lateinit var binding: ActivityLoginBinding
    lateinit var presenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title="Login"

        presenter= LoginPresenter(this, AppDatabase.getDatabase(this).userDao())

        binding.buttonRegister.setOnClickListener {
            startActivity(Intent(this,RegistrationActivity::class.java))
        }
        binding.loginButton.setOnClickListener {
            if (TextUtils.isEmpty(binding.username.text.toString())){
                binding.userNameTextInputLayout.error="Enter User Name"
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(binding.password.text.toString())){
                binding.passwordTextInputLayout.error="Enter Password"
                return@setOnClickListener
            }
            presenter.performLogin(binding.username.text.toString(),binding.password.text.toString())
        }
    }

    override fun onLoginSuccess() {
        Toast.makeText(this,"Login Successfully", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this,MainActivity::class.java))
    }

    override fun showError(error: Int) {
        MaterialAlertDialogBuilder(this)
            .setMessage(getString(error))
            .setPositiveButton("Ok") { dialog, which ->
                // Respond to positive button press
            }.show()
    }

}