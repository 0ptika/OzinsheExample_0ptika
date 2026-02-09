package com.example.ozinsheexample.presentation.login

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ozinsheexample.R
import com.example.ozinsheexample.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnShowPassword.setOnClickListener {
            togglePasswordVisibility()
        }

        binding.btnLogin.setOnClickListener {
            validationEmail(emailValidation(binding.editTextEmail.text.toString()))
            validationPassword(binding.editTextPassword.text.toString())
        }
    }

    fun togglePasswordVisibility() {
        val passwordEditText = binding.editTextPassword
        passwordEditText.transformationMethod = if(passwordEditText.transformationMethod == HideReturnsTransformationMethod.getInstance()) {
            PasswordTransformationMethod.getInstance()
        } else {
            HideReturnsTransformationMethod.getInstance()
        }
    }

    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    fun emailValidation(email: String): Boolean {
        return email.trim().matches(emailPattern.toRegex())
    }
    fun validationEmail(isValed: Boolean){
        if(isValed){
            binding.tvErrorTextEmail.error = ""
            binding.tvErrorTextEmail.visibility = View.GONE
            binding.editTextEmail.setBackgroundResource(R.drawable.background_edittext_focus_action_12dp)
        }else{
            binding.tvErrorTextEmail.error = "Қате формат"
            binding.tvErrorTextEmail.visibility = View.VISIBLE
            binding.editTextEmail.setBackgroundResource(R.drawable.background_edittext_12dp_error)

        }
    }

    fun validationPassword(password: String): Boolean{
        return if (password.length < 6 ){
            binding.tvErrorTextPasswordAndServer.text = "Ваш текст не превышает 6 символов"
            binding.editTextPassword.setBackgroundResource(R.drawable.background_edittext_12dp_error)
            binding.tvErrorTextPasswordAndServer.visibility = View.VISIBLE
            false
        }else{
            binding.tvErrorTextPasswordAndServer.visibility = View.GONE
            binding.editTextEmail.setBackgroundResource(R.drawable.background_edittext_focus_action_12dp)
            true
        }


    }




}