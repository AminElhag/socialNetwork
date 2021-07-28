package sd.lemon.socialnetwork.data.login

import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST
import sd.lemon.socialnetwork.domain.login.LoginUseCase
import sd.lemon.socialnetwork.domain.login.models.LoginResponse

interface LoginRetrofitService {
    @POST("login")
    fun login(@Body parameters: LoginUseCase.Parameters): Observable<LoginResponse>
}