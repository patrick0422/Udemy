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
import com.example.navdemo2.databinding.FragmentEmailBinding

class EmailFragment : Fragment() {
    private lateinit var binding: FragmentEmailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_email, container, false)
        binding.btnNext.setOnClickListener {
            if (binding.etEmail.text.isNotEmpty()) {
                UserViewModel.userEmail = binding.etEmail.text.toString()
                it.findNavController().navigate(R.id.action_emailFragment_to_welcomeFragment)
            } else Toast.makeText(context, "Please enter your Email.", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }
}