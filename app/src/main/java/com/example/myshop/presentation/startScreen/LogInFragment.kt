package com.example.myshop.presentation.startScreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myshop.R
import com.example.myshop.databinding.FragmentLogInBinding
import com.example.myshop.presentation.MyApp
import com.example.myshop.presentation.ViewModelFactory
import com.example.myshop.presentation.secondScreen.MainActivity
import com.example.myshop.presentation.viewModels.UserViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


class LogInFragment : Fragment() {

    private lateinit var binding: FragmentLogInBinding
    private lateinit var viewModel: UserViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as MyApp).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLogInBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this, viewModelFactory)[UserViewModel::class.java]

        binding.imageView6.setOnClickListener{

            if (binding.imageView6.isSelected) {
                binding.imageView6.isSelected = false
                binding.editPassword.inputType = InputType
                    .TYPE_CLASS_TEXT or InputType
                    .TYPE_TEXT_VARIATION_PASSWORD
            } else {
                binding.imageView6.isSelected = true
                binding.editPassword.inputType = InputType.TYPE_CLASS_TEXT
            }
        }

        binding.buttonSignIn.setOnClickListener {

            if (binding.firstNameText.text.toString() == "") {
                binding.firstNameText.error = resources.getString(R.string.errorFirstName)
                binding.firstNameText.requestFocus()
            } else {
                CoroutineScope(Dispatchers.IO).launch {
                    val check = viewModel.checkUser(binding.firstNameText.text.toString())
                    if (!check) {
                        withContext(Dispatchers.Main) {
                            binding.firstNameText.error = resources.getString(R.string.not_found)
                        }
                    } else {
                        startActivity(Intent(activity, MainActivity::class.java))
                        activity?.finish()
                    }
                }
            }
        }
        return binding.root
    }


}