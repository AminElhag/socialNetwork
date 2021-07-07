package sd.lemon.socialnetwork.domain.login

import io.reactivex.Observable
import sd.lemon.socialnetwork.domain.login.models.LoginResponse

interface LoginRepository {
    fun login(userName: String, userPassword: String): Observable<LoginResponse>
}