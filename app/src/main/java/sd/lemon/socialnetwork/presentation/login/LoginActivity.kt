package sd.lemon.socialnetwork.presentation.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.android.material.snackbar.Snackbar
import sd.lemon.socialnetwork.R
import sd.lemon.socialnetwork.presentation.app.App
import sd.lemon.socialnetwork.presentation.main.MainActivity
import sd.lemon.socialnetwork.presentation.login.di.DaggerLoginComponent
import sd.lemon.socialnetwork.presentation.login.di.LoginModule
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginView {

    private lateinit var progressBar: ProgressBar
    private lateinit var button: Button
    private lateinit var userNameEditText: EditText
    private lateinit var userPasswordEditText: EditText
    private lateinit var toolbar: Toolbar

    @Inject
    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        //TODO build
        DaggerLoginComponent.builder()
            .loginModule(LoginModule(this))
            .appComponent((application as App).appComponent)
            .build()
            .inject(this)


        button = findViewById(R.id.loginButton)
        userNameEditText = findViewById(R.id.userNameEditText)
        userPasswordEditText = findViewById(R.id.userPasswordEditText)
        progressBar = findViewById(R.id.progressBar)
        toolbar = findViewById(R.id.include)

        setSupportActionBar(toolbar)

        button.setOnClickListener {
            presenter.login(userNameEditText.text.toString(), userPasswordEditText.text.toString())
        }
    }

    override fun onLoginSuccess() {
        Toast.makeText(this, "Login success", Toast.LENGTH_LONG).show()
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun onLoginFailed() {
//        Toast.makeText(this, "Login failed", Toast.LENGTH_LONG).show()
        Snackbar.make(findViewById(android.R.id.content), "Login Failed", Snackbar.LENGTH_LONG)
            .setAction("Dismiss") { }
            .show()
    }

    override fun onError(throwable: Throwable?) {
        Toast.makeText(this, throwable?.message ?: "", Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun disableButton() {
        button.isEnabled = false
    }

    override fun enableButton() {
        button.isEnabled = true
    }
}