package com.example.bloggingapp.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.bloggingapp.R
import kotlinx.android.synthetic.main.fragment_launcher.*

class LauncherFragment : BaseAuthFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_launcher, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        register.setOnClickListener{
            navRegistration()
        }
        login.setOnClickListener{
            navlogin()
        }
        forgot_password.setOnClickListener{
            navForgotPassword()
        }

        focusable_view.requestFocus()

    }

    private fun navForgotPassword() {
      findNavController().navigate(R.id.action_launcherFragment_to_forgotPasswordFragment)
    }

    private fun navlogin() {
findNavController().navigate(R.id.action_launcherFragment_to_loginFragment)


    }

    private fun navRegistration() {
findNavController().navigate(R.id.action_launcherFragment_to_registerFragment)
    }


}