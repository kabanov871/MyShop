package com.example.myshop.presentation.startScreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myshop.R
import com.example.myshop.databinding.FragmentSignInBinding
import com.example.myshop.domain.models.UserModel
import com.example.myshop.presentation.MyApp
import com.example.myshop.presentation.ViewModelFactory
import com.example.myshop.presentation.secondScreen.MainActivity
import com.example.myshop.presentation.viewModels.UserViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding
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
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this, viewModelFactory)[UserViewModel::class.java]

        binding.buttonSignIn.setOnClickListener {

            if (binding.firstNameText.text.toString() == "") {
                binding.firstNameText.error = resources.getString(R.string.errorFirstName)
                binding.firstNameText.requestFocus()
            } else {
                if (binding.lastNameText.text.toString() == "") {
                    binding.lastNameText.error = resources.getString(R.string.errorLastName)
                    binding.lastNameText.requestFocus()
                } else {
                    val email: String = binding.emailText.text.toString().trim()

                    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        binding.emailText.error = resources.getString(R.string.errorEmail)
                        binding.emailText.requestFocus()
                    } else {
                        CoroutineScope(Dispatchers.IO).launch {
                            val check = viewModel.checkUser(binding.firstNameText.text.toString())
                            if (check) {
                                withContext(Dispatchers.Main) {
                                    binding.firstNameText.error = resources.getString(R.string.exists)
                                }
                            } else {
                                 viewModel.insertUser(UserModel(
                                     0,
                                     binding.firstNameText.text.toString(),
                                     binding.lastNameText.text.toString(),
                                     binding.emailText.text.toString()
                                 ))
                                 startActivity(Intent(activity, MainActivity::class.java))
                                 activity?.finish()
                            }
                        }
                    }
                }
            }
        }

        binding.signGoogle.setOnClickListener{
            findNavController().navigate(R.id.action_signInFragment_to_signInGoogleFragment)
        }

        binding.signApple.setOnClickListener{
            findNavController().navigate(R.id.action_signInFragment_to_signInAppleFragment)

        }

        binding.textLogin.setOnClickListener{
            findNavController().navigate(R.id.action_signInFragment_to_logInFragment)
        }

        return binding.root
    }
}