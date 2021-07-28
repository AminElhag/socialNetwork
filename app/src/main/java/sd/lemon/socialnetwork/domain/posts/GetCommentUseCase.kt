package sd.lemon.socialnetwork.domain.posts

import io.reactivex.Observable
import sd.lemon.socialnetwork.domain.common.UseCase
import sd.lemon.socialnetwork.domain.posts.models.Post

class GetCommentUseCase(private val repository: PostsRepository)  : UseCase<GetCommentUseCase.Parameters, List<Post>>{

    override fun execute(parameters: Parameters): Observable<List<Post>> {
        return repository.getComment(parameters)
    }

    class Parameters(val id: Int) : UseCase.Parameters
}