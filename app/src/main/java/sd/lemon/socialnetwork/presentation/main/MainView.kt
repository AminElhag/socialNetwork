package sd.lemon.socialnetwork.presentation.main

import sd.lemon.socialnetwork.domain.posts.models.Post

interface MainView {
    fun error(it: Throwable?)
    fun getPost(it: List<Post>)
    fun togglePostButton(enabled: Boolean)
    fun toggleProgressMessage(show: Boolean)
    fun postCreated()
    fun clarePostFielded()
    fun onCellClickListener(post: Post)
}