package sd.lemon.socialnetwork.presentation.login.di

import dagger.Component
import sd.lemon.socialnetwork.presentation.app.di.AppComponent
import sd.lemon.socialnetwork.presentation.app.di.PerActivity
import sd.lemon.socialnetwork.presentation.login.LoginActivity

@Component(modules = [LoginModule::class], dependencies = [AppComponent::class])
@PerActivity
interface LoginComponent {
    fun inject(loginActivity: LoginActivity)
}