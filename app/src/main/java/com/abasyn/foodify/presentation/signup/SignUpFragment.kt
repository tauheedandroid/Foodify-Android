package com.abasyn.foodify.presentation.signup

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.abasyn.foodify.R
import com.abasyn.foodify.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    private lateinit var binding: FragmentSignUpBinding
    private val viewModel: SignUpViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSignUpBinding.bind(view)

        binding.SignUpBtn.setOnClickListener {

            val email = binding.SignUpEtEmail.text.toString().trim()
            val password = binding.SignUpEtPassword.text.toString().trim()

            viewModel.signUp(email, password)
        }

        viewModel.signUpSuccess.observe(viewLifecycleOwner) { success ->

            if (success) {

                Toast.makeText(requireContext(), "Signup Successful", Toast.LENGTH_SHORT).show()

                findNavController().navigate(
                    R.id.action_signUpFragment_to_loginFragment
                )

            } else {

                Toast.makeText(
                    requireContext(),
                    "Please enter Email & Password",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}