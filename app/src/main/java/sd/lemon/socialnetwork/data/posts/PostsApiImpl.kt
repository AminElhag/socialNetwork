package sd.lemon.socialnetwork.data.posts

import io.reactivex.Completable
import io.reactivex.Observable
import sd.lemon.socialnetwork.domain.posts.*
import sd.lemon.socialnetwork.domain.posts.models.Post

class PostsApiImpl(private val service: PostsRetrofitService) : PostsRepository {

    override fun getPosts(parameters: GetPostsUseCase.Parameters): Observable<List<Post>> {
        return service.getPosts()
    }

    override fun getOnePost(parameters: GetOnePostUseCase.Parameters): Observable<Post> {
        return service.getOnePost(parameters.id)
    }

    override fun getComment(parameters: GetCommentUseCase.Parameters): Observable<List<Post>> {
        return service.getCommentsByPostId(parameters.id)
    }

    override fun cratePost(parameters: CreatePostUseCase.Parameters): Observable<Post> {
        return service.crateNewPost(parameters)
    }

    override fun deletePost(id: Int): Completable {
        return service.deletePost(id)
    }
}