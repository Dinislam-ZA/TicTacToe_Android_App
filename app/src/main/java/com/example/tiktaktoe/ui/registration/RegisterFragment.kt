package com.example.tiktaktoe.ui.registration

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.tiktaktoe.databinding.RegisterFragmentBinding

class RegisterFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterFragment()
    }


    private lateinit var binding: RegisterFragmentBinding
    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RegisterFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

      //  viewModel.userData.observe(viewLifecycleOwner
      //  ) { user -> binding.userName.setText(viewModel.userData.value?.username.toString()) }



        binding.registerButton.setOnClickListener(){
            viewModel.tryRegistration(binding.userName.text.toString(),
                binding.userPassword.text.toString(),
                "",
                binding.userPhoneNumber.text.toString())
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        viewModel.isOk.observe(viewLifecycleOwner) { it ->
            if (it == true) binding.root.findNavController().popBackStack()
        }
    }

}