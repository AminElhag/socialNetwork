package sd.lemon.socialnetwork.domain.posts

import io.reactivex.Observable
import sd.lemon.socialnetwork.domain.common.UseCase
import sd.lemon.socialnetwork.domain.posts.models.Post

class GetOnePostUseCase(private val postsRepository: PostsRepository):UseCase<GetOnePostUseCase.Parameters,Post> {

    override fun execute(parameters: Parameters): Observable<Post> {
        return postsRepository.getOnePost(parameters)
    }

    class Parameters(val id: Int) : UseCase.Parameters
}