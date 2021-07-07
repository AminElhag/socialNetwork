package sd.lemon.socialnetwork.data.posts

import io.reactivex.Completable
import io.reactivex.Observable
import sd.lemon.socialnetwork.domain.posts.PostsRepository
import sd.lemon.socialnetwork.domain.posts.models.Post

class PostsApiImpl(private val service: PostsRetrofitService) : PostsRepository {

    override fun getPosts(): Observable<List<Post>> {
        return service.getPosts()
    }

    override fun getOnePost(id: Int): Observable<Post> {
        return service.getOnePost(id)
    }

    override fun getComment(id: Int): Observable<List<Post>> {
        return service.getCommentsByPostId(id)
    }

    override fun cratePost(post: Post): Observable<Post> {
        return service.crateNewPost(post)
    }

    override fun deletePost(id: Int): Completable {
        return service.deletePost(id)
    }
}