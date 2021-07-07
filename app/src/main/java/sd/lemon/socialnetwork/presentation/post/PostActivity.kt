package sd.lemon.socialnetwork.presentation.post

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import sd.lemon.socialnetwork.R
import sd.lemon.socialnetwork.domain.posts.models.Post
import sd.lemon.socialnetwork.presentation.main.PostAdapter
import sd.lemon.socialnetwork.presentation.post.di.DaggerPostComponent
import sd.lemon.socialnetwork.presentation.post.di.PostModule
import javax.inject.Inject

class PostActivity : AppCompatActivity(), PostView {

    private lateinit var titleTextView: TextView
    private lateinit var bodyTextView: TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: PostAdapter

    @Inject
    lateinit var presenter: PostPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        titleTextView = findViewById(R.id.tv_title_Post)
        bodyTextView = findViewById(R.id.tv_body_Post)
        recyclerView = findViewById(R.id.recycler_view_comment)

        val postID = intent.getIntExtra("TheSelectPost", 0)

        DaggerPostComponent
            .builder()
            .postModule(PostModule(this))
            .build().inject(this)

        presenter.setPostId(postID)

        presenter.showPost()
        presenter.showComments()
    }

    override fun showPost(post: Post) {
        titleTextView.text = post.title
        bodyTextView.text = post.body
    }

    override fun showComments(comments: List<Post>) {
        itemAdapter = PostAdapter(comments)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = itemAdapter
    }

    override fun error(it: Throwable?) {
        Snackbar.make(findViewById(android.R.id.content),
            "Error:${it?.message}",
            Snackbar.LENGTH_LONG)
            .show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}