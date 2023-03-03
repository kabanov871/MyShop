package com.example.myshop.presentation.startScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myshop.databinding.FragmentSignInGoogleBinding


class SignInGoogleFragment : Fragment() {

    private lateinit var binding: FragmentSignInGoogleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInGoogleBinding.inflate(inflater, container, false)
        return binding.root
    }
}