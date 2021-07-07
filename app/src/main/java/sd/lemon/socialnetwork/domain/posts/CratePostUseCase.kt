package sd.lemon.socialnetwork.domain.posts

import io.reactivex.Observable
import sd.lemon.socialnetwork.domain.posts.models.Post

class CratePostUseCase(private val repository: PostsRepository) {

    fun execute(post: Post): Observable<Post> {
        return repository.cratePost(post)
    }
}