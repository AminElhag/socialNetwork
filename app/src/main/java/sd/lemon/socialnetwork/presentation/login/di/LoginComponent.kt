package sd.lemon.socialnetwork.presentation.login.di

import dagger.Component
import sd.lemon.socialnetwork.presentation.login.LoginActivity
import javax.inject.Singleton

@Component(modules = [LoginModule::class])
@PerActivity
interface LoginComponent {
    fun inject(loginActivity: LoginActivity)
}