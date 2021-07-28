package sd.lemon.socialnetwork.presentation.login

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import sd.lemon.socialnetwork.domain.login.LoginUseCase

class LoginPresenter(
    private val view: LoginView,
    private val loginUseCase: LoginUseCase,
) {

    private val compositeDisposable = CompositeDisposable()

    fun login(username: String, password: String) {
        view.showLoading()
        view.disableButton()
        val subscription = loginUseCase.execute(LoginUseCase.Parameters(username, password))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.hideLoading()
                view.enableButton()
                if (it.success) {
                    view.onLoginSuccess()
                } else {
                    view.onLoginFailed()
                }
            }, {
                view.onLoginSuccess()
                view.hideLoading()
                view.enableButton()
                view.onError(it)
            })

        compositeDisposable.add(subscription)
    }

    fun onDestroy() {
        compositeDisposable.clear()
    }


}