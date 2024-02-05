package com.example.tiktaktoe.ui.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.tiktaktoe.R
import com.example.tiktaktoe.data.LoginRequest
import com.example.tiktaktoe.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.regButton.setOnClickListener(){
            view.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        
        binding.logButton.setOnClickListener(){
            viewModel.loginUser(LoginRequest(binding.userName.text.toString(), binding.userPassword.text.toString()))
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        viewModel.isOk.observe(viewLifecycleOwner) {it -> if(it == true) binding.root.findNavController().navigate(R.id.action_loginFragment_to_menuFragment2)}
    }

}