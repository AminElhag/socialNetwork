package sd.lemon.socialnetwork.domain.login

import io.reactivex.Observable
import sd.lemon.socialnetwork.domain.login.models.LoginResponse

class LoginUseCase(private val loginRepository: LoginRepository) {
    fun execute(userName: String, userPassword: String): Observable<LoginResponse> {
        return loginRepository.login(userName, userPassword)
    }
}