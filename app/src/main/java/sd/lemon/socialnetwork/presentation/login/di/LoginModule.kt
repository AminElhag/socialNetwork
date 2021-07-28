package sd.lemon.socialnetwork.presentation.login.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import sd.lemon.socialnetwork.data.login.LoginApiImpl
import sd.lemon.socialnetwork.data.login.LoginRetrofitService
import sd.lemon.socialnetwork.domain.login.LoginRepository
import sd.lemon.socialnetwork.domain.login.LoginUseCase
import sd.lemon.socialnetwork.presentation.app.di.PerActivity
import sd.lemon.socialnetwork.presentation.login.LoginPresenter
import sd.lemon.socialnetwork.presentation.login.LoginView

@Module
class LoginModule(private val view: LoginView) {

    @Provides
    @PerActivity
    fun provideLoginRetrofitService(retrofit: Retrofit): LoginRetrofitService {
        return retrofit.create(LoginRetrofitService::class.java)
    }

    @Provides
    @PerActivity
    fun provideLoginRepository(loginRetrofitService: LoginRetrofitService): LoginRepository {
        return LoginApiImpl(loginRetrofitService)
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