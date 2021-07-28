package sd.lemon.socialnetwork.domain.login

import com.google.gson.annotations.SerializedName
import io.reactivex.Observable
import sd.lemon.socialnetwork.domain.common.UseCase
import sd.lemon.socialnetwork.domain.login.models.LoginResponse

class LoginUseCase(private val loginRepository: LoginRepository) :
    UseCase<LoginUseCase.Parameters, LoginResponse> {

    override fun execute(parameters: Parameters): Observable<LoginResponse> {
        return loginRepository.login(parameters)
    }

    class Parameters(
        @SerializedName("user_name") val userName: String,
        @SerializedName("user_password") val userPassword: String,
    ) : UseCase.Parameters
}