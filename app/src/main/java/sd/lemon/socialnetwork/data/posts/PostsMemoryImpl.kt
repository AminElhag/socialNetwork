package sd.lemon.socialnetwork.data.posts

import io.reactivex.Completable
import io.reactivex.Observable
import sd.lemon.socialnetwork.domain.posts.*
import sd.lemon.socialnetwork.domain.posts.models.Post

class PostsMemoryImpl : PostsRepository {



    override fun getPosts(parameters: GetPostsUseCase.Parameters): Observable<List<Post>> {
        TODO("Not yet implemented")
    }

    override fun getOnePost(parameters: GetOnePostUseCase.Parameters): Observable<Post> {
        TODO("Not yet implemented")
    }

    override fun getComment(parameters: GetCommentUseCase.Parameters): Observable<List<Post>> {
        TODO("Not yet implemented")
    }

    override fun cratePost(parameters: CreatePostUseCase.Parameters): Observable<Post> {
        TODO("Not yet implemented")
    }

    override fun deletePost(id: Int): Completable {
        TODO("Not yet implemented")
    }
}