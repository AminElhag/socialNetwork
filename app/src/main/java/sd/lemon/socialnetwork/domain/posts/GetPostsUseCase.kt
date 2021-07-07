package sd.lemon.socialnetwork.domain.posts

import io.reactivex.Observable
import sd.lemon.socialnetwork.domain.posts.models.Post

class GetPostsUseCase(private val repository: PostsRepository) {

    fun execute(): Observable<List<Post>> {
        return repository.getPosts()
    }

}