package sd.lemon.socialnetwork.domain.posts

import io.reactivex.Observable
import sd.lemon.socialnetwork.domain.posts.models.Post

class GetOnePostUseCase(private val postsRepository: PostsRepository) {

    fun execute(id: Int): Observable<Post> {
        return postsRepository.getOnePost(id)
    }
}