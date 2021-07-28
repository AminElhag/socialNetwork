package sd.lemon.socialnetwork.data.login

import io.reactivex.Observable
import sd.lemon.socialnetwork.domain.login.LoginRepository
import sd.lemon.socialnetwork.domain.login.LoginUseCase
import sd.lemon.socialnetwork.domain.login.models.LoginResponse

class LoginApiImpl(private val loginRetrofitService: LoginRetrofitService) : LoginRepository {
    override fun login(parameters: LoginUseCase.Parameters): Observable<LoginResponse> =
        loginRetrofitService.login(parameters)

}