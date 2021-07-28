package sd.lemon.socialnetwork.domain.posts

import io.reactivex.Completable
import io.reactivex.Observable
import sd.lemon.socialnetwork.domain.posts.models.Post

interface PostsRepository {
    fun getPosts(parameters: GetPostsUseCase.Parameters): Observable<List<Post>>
    fun getOnePost(parameters: GetOnePostUseCase.Parameters): Observable<Post>
    fun getComment(parameters: GetCommentUseCase.Parameters): Observable<List<Post>>
    fun cratePost(parameters: CreatePostUseCase.Parameters): Observable<Post>
    fun deletePost(id: Int): Completable
}