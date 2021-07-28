package sd.lemon.socialnetwork.data.posts

import io.reactivex.Completable
import io.reactivex.Observable
import retrofit2.http.*
import sd.lemon.socialnetwork.domain.posts.CreatePostUseCase
import sd.lemon.socialnetwork.domain.posts.models.Post

interface PostsRetrofitService {
    @GET("posts")
    fun getPosts(): Observable<List<Post>>

    @GET("posts/{id}")
    fun getOnePost(@Path("id") id: Int): Observable<Post>

    @GET("posts/{id}/comments")
    fun getCommentsByPostId(@Path("id") id: Int): Observable<List<Post>>

    @POST("posts")
    fun crateNewPost(@Body parameters: CreatePostUseCase.Parameters): Observable<Post>

    @DELETE("posts/{id}")
    fun deletePost(@Path("id") id: Int): Completable

}