package com.example.ozinsheexample.presentation.login

import android.os.Bundle
import android.os.Message
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.ozinsheexample.R
import com.example.ozinsheexample.data.SharedProvider
import com.example.ozinsheexample.data.model.LoginRequest
import com.example.ozinsheexample.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel : LoginViewModel by viewModels()

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
        viewModel.loginResponse.observe(viewLifecycleOwner){
            binding.tvErrorTextPasswordAndServer.visibility = View.GONE
            Toast.makeText(requireContext(),"$it" , Toast.LENGTH_SHORT).show()
            SharedProvider(requireContext()).saveToken(it.accessToken)
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)

        }
        viewModel.errorResponse.observe(viewLifecycleOwner){
            showError(it)
        }

        binding.btnBackLogin.setOnClickListener {
            findNavController().navigate(R.id.onBoardingFragment)
        }

        binding.btnShowPassword.setOnClickListener {
            togglePasswordVisibility()
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()

            val emailIsValid = emailValidation(email)
            val passwordIsValid = validationPassword(password)
            if (emailIsValid && passwordIsValid){
                viewModel.loginUser(email,password)
            }else {
                validationEmail(isVisible)
            }
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
    fun showError(message: String){
        binding.tvErrorTextPasswordAndServer.text = message
        binding.tvErrorTextPasswordAndServer.visibility = View.VISIBLE
    }




}