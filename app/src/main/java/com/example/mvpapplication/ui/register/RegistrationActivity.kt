package com.example.mvpapplication.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.mvpapplication.databinding.ActivityRegistrationBinding
import com.example.mvpapplication.local_db.AppDatabase
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class RegistrationActivity : AppCompatActivity(),RegisterContract.View {
    lateinit var binding:ActivityRegistrationBinding
    lateinit var presenter: RegisterContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Register User"
        presenter= RegisterPresenter(this, AppDatabase.getDatabase(this).userDao())
        binding.registerButton.setOnClickListener {
            if (TextUtils.isEmpty(binding.username.text.toString())){
                binding.userNameTextInputLayout.error="Enter User Name"
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(binding.fullName.text.toString())){
                binding.fullNameTextInputLayout.error="Enter Full Name"
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(binding.email.text.toString())){
                binding.emailTextInputLayout.error="Enter Email"
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(binding.password.text.toString())){
                binding.passwordTextInputLayout.error="Enter Password"
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(binding.confirmPassword.text.toString())){
                binding.confirmPasswordTextInputLayout.error="Confirm Password"
                return@setOnClickListener
            }
            if (!binding.confirmPassword.text.toString().equals(binding.password.text.toString(),false)){
                binding.confirmPasswordTextInputLayout.error="Password Does Not Match"
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(binding.mobileNo.text.toString())){
                binding.mobileTextInputLayout.error="Enter Mobile Number"
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(binding.address.text.toString())){
                binding.addressTextInputLayout.error="Enter Address"
                return@setOnClickListener
            }
            presenter.performRegistration(binding.fullName.text.toString(),binding.username.text.toString(),binding.email.text.toString(),binding.password.text.toString(),binding.mobileNo.text.toString(),binding.address.text.toString())
        }
    }

    override fun onRegistrationComplete() {
        Toast.makeText(this,"Register Successfully",Toast.LENGTH_SHORT).show()
        onBackPressed()
    }

    override fun showError(error: Int) {
        MaterialAlertDialogBuilder(this)
            .setMessage(getString(error))
            .setPositiveButton("Ok") { dialog, which ->
                // Respond to positive button press
            }.show()
    }
}