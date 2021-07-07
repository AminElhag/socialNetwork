package sd.lemon.socialnetwork.presentation.post

import sd.lemon.socialnetwork.domain.posts.models.Post

interface PostView {
    fun error(it: Throwable?)
    fun showPost(post: Post)
    fun showComments(comments: List<Post>)
}