package sd.lemon.socialnetwork.data.posts

import io.reactivex.Completable
import io.reactivex.Observable
import sd.lemon.socialnetwork.domain.posts.PostsRepository
import sd.lemon.socialnetwork.domain.posts.models.Post

class PostsMemoryImpl : PostsRepository {

    private val posts = mutableListOf<Post>()

    override fun getPosts(): Observable<List<Post>> {
        return Observable.just(posts)
    }

    override fun getOnePost(id: Int): Observable<Post> {
        val post = posts.firstOrNull { it.id == id }
        return Observable.just(post)
    }

    override fun getComment(id: Int): Observable<List<Post>> {
        TODO("Not yet implemented")
    }

    override fun cratePost(post: Post): Observable<Post> {
        TODO("Not yet implemented")
    }

    override fun deletePost(id: Int): Completable {
        TODO("Not yet implemented")
    }
}