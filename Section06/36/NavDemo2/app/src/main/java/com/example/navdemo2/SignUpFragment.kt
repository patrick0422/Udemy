package com.example.navdemo2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.navdemo2.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false)
        binding.btnNext.setOnClickListener {
            if (binding.etName.text.isNotEmpty()) {
                UserViewModel.userName = binding.etName.text.toString()
                it.findNavController().navigate(R.id.action_signUpFragment_to_emailFragment)
            } else Toast.makeText(context, "Please enter your Name.", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }
}