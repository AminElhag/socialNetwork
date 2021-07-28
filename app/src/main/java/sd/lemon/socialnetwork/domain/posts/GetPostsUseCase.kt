package sd.lemon.socialnetwork.domain.posts

import io.reactivex.Observable
import sd.lemon.socialnetwork.domain.common.UseCase
import sd.lemon.socialnetwork.domain.posts.models.Post

class GetPostsUseCase(private val repository: PostsRepository) :
    UseCase<GetPostsUseCase.Parameters, List<Post>> {

    override fun execute(parameters: Parameters): Observable<List<Post>> {
        return repository.getPosts(parameters)
    }

    class Parameters() : UseCase.Parameters
}