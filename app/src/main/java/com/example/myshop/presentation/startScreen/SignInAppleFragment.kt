package com.example.myshop.presentation.startScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myshop.R
import com.example.myshop.databinding.FragmentSignInAppleBinding
import com.example.myshop.databinding.FragmentSignInGoogleBinding


class SignInAppleFragment : Fragment() {

    private lateinit var binding: FragmentSignInAppleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInAppleBinding.inflate(inflater, container, false)
        return binding.root
    }

}