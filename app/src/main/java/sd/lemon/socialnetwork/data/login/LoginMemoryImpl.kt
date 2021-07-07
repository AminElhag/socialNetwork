package sd.lemon.socialnetwork.data.login

import io.reactivex.Observable
import sd.lemon.socialnetwork.domain.login.LoginRepository
import sd.lemon.socialnetwork.domain.login.models.LoginResponse
import java.util.concurrent.TimeUnit

class LoginMemoryImpl : LoginRepository {

    override fun login(userName: String, userPassword: String): Observable<LoginResponse> {
        return Observable
            .just(LoginResponse(userName == "Admin" && userPassword == "1234"))
            .delay(3, TimeUnit.SECONDS)
    }
}