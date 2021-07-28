package sd.lemon.socialnetwork.presentation.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.materialdialogs.MaterialDialog
import com.google.android.material.snackbar.Snackbar
import sd.lemon.socialnetwork.R
import sd.lemon.socialnetwork.domain.posts.models.Post
import sd.lemon.socialnetwork.presentation.app.App
import sd.lemon.socialnetwork.presentation.main.di.DaggerMainComponent
import sd.lemon.socialnetwork.presentation.main.di.MainModule
import sd.lemon.socialnetwork.presentation.post.PostActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var editTextCreatePost: EditText
    private lateinit var buttonCreatePost: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: PostAdapter

    @Inject
    lateinit var presenter: MainPresenter
    private lateinit var dialog: MaterialDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextCreatePost = findViewById(R.id.etCreatePost)
        buttonCreatePost = findViewById(R.id.buttonCreatePost)

        recyclerView = findViewById(R.id.recyclerView)

        initDialog()

        buttonCreatePost.isEnabled = false

        DaggerMainComponent
            .builder()
            .mainModule(MainModule(this))
            .appComponent((application as App).appComponent)
            .build().inject(this)

        presenter.getPost()

        editTextCreatePost.addTextChangedListener { presenter.postFieldChange(it.toString()) }

        buttonCreatePost.setOnClickListener {
            presenter.onSubmitPost(editTextCreatePost.text.toString())
        }
    }

    private fun initDialog() {
        dialog = MaterialDialog(this)
            .title(text = "Wait")
            .message(text = "Creating Post ...")
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }


    override fun error(it: Throwable?) {
        Toast.makeText(this, "Error: ${it?.message}", Toast.LENGTH_LONG).show()
    }

    override fun getPost(it: List<Post>) {
        itemAdapter = PostAdapter(it)
        itemAdapter.setOnActionsListener(object : PostAdapter.OnActionsListener {
            override fun onPostClicked(post: Post) {
                startActivity(Intent(this@MainActivity, PostActivity::class.java).apply {
                    putExtra("TheSelectPost", post.id)
                })
            }

        })

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = itemAdapter
    }

    override fun togglePostButton(enabled: Boolean) {
        buttonCreatePost.isEnabled = enabled
    }

    override fun toggleProgressMessage(show: Boolean) {
        if (show) {
            dialog.show()
        } else {
            if (dialog.isShowing) dialog.dismiss()
        }
    }

    override fun postCreated() {
        Snackbar.make(findViewById(android.R.id.content), "Post Crated", Snackbar.LENGTH_LONG)
            .show()
    }

    override fun clarePostFielded() {
        editTextCreatePost.setText("")
    }

    override fun onCellClickListener(post: Post) {

    }

}

