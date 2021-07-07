package sd.lemon.socialnetwork.domain.posts

import io.reactivex.Completable
import io.reactivex.Observable
import sd.lemon.socialnetwork.domain.posts.models.Post

interface PostsRepository {
    fun getPosts(): Observable<List<Post>>
    fun getOnePost(id: Int): Observable<Post>
    fun getComment(id: Int): Observable<List<Post>>
    fun cratePost(post: Post): Observable<Post>
    fun deletePost(id: Int): Completable
}