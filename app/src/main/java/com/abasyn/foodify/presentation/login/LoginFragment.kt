package com.abasyn.foodify.presentation.login

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.abasyn.foodify.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val viewModel: LoginViewModel by viewModel()

    private lateinit var emailEt: EditText
    private lateinit var passwordEt: EditText
    private lateinit var loginBtn: Button
    private lateinit var newUserTv: TextView   // 👈 added

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        emailEt = view.findViewById(R.id.LoginEmail)
        passwordEt = view.findViewById(R.id.LoginPassword)
        loginBtn = view.findViewById(R.id.Login_btn)
        newUserTv = view.findViewById(R.id.Login_tv_NewUser)  // 👈 initialize

        loginBtn.setOnClickListener {

            val email = emailEt.text.toString().trim()
            val password = passwordEt.text.toString().trim()

            if (email.isEmpty()) {
                emailEt.error = "Email required"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                passwordEt.error = "Password required"
                return@setOnClickListener
            }

            viewModel.login(email, password)
        }

        // 👇 NEW USER CLICK
        newUserTv.setOnClickListener {
            findNavController().navigate(
                R.id.action_loginFragment_to_signUpFragment
            )
        }

        viewModel.loginSuccess.observe(viewLifecycleOwner) { success ->

            if (success) {

                Toast.makeText(requireContext(), "Login Successful", Toast.LENGTH_SHORT).show()

                findNavController().navigate(
                    R.id.action_loginFragment_to_homeFragment
                )

            } else {

                Toast.makeText(
                    requireContext(),
                    "Invalid Email or Password",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}