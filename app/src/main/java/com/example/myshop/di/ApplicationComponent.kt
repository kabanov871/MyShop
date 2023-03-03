package com.example.myshop.di

import android.app.Application
import com.example.myshop.presentation.secondScreen.ChatFragment
import com.example.myshop.presentation.secondScreen.DetailFragment
import com.example.myshop.presentation.secondScreen.HomeFragment
import com.example.myshop.presentation.startScreen.LogInFragment
import com.example.myshop.presentation.startScreen.SignInFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(fragment: HomeFragment)

    fun inject(fragment: SignInFragment)

    fun inject(fragment: LogInFragment)

    fun inject(fragment: DetailFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}