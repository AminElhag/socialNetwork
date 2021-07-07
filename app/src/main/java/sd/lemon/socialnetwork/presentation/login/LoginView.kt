package sd.lemon.socialnetwork.presentation.login

interface LoginView {
    fun onLoginSuccess()
    fun onLoginFailed()
    fun onError(throwable: Throwable?)
    fun showLoading()
    fun hideLoading()
    fun disableButton()
    fun enableButton()
}