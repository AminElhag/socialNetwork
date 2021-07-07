package sd.lemon.socialnetwork.domain.posts

import io.reactivex.Observable
import sd.lemon.socialnetwork.domain.posts.models.Post

class GetCommentUseCase(private val repository: PostsRepository) {

    fun execute(id: Int): Observable<List<Post>> {
        return repository.getComment(id)
    }
}