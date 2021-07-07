package sd.lemon.socialnetwork.presentation.login.di

import dagger.Module
import dagger.Provides
import sd.lemon.socialnetwork.data.login.LoginMemoryImpl
import sd.lemon.socialnetwork.domain.login.LoginRepository
import sd.lemon.socialnetwork.domain.login.LoginUseCase
import sd.lemon.socialnetwork.presentation.login.LoginPresenter
import sd.lemon.socialnetwork.presentation.login.LoginView

@Module
class LoginModule(private val view: LoginView) {

    @Provides
    @PerActivity
    fun provideLoginRepository(): LoginRepository {
        return LoginMemoryImpl()
    }

    @Provides
    @PerActivity
    fun provideLoginUseCase(loginRepository: LoginRepository): LoginUseCase {
        return LoginUseCase(loginRepository)
    }

    @Provides
    @PerActivity
    fun provideLoginPresenter(loginUseCase: LoginUseCase): LoginPresenter {
        return LoginPresenter(view, loginUseCase)
    }
}