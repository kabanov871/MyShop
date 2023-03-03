package com.example.myshop.presentation.secondScreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myshop.R
import com.example.myshop.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame, HomeFragment.newInstance())
            .commit()

        binding.bNav.selectedItemId = R.id.item1
        binding.bNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item1 -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame, HomeFragment.newInstance())
                        .commit()
                }
                R.id.item2 -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame, FavoritesFragment.newInstance())
                        .commit()
                }
                R.id.item3 -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame, SaleFragment.newInstance())
                        .commit()
                }
                R.id.item4 -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame, ChatFragment.newInstance())
                        .commit()
                }
                R.id.item5 -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame, ProfileFragment.newInstance())
                        .commit()
                }
            }
            true
        }
    }

}