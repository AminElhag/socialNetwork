package sd.lemon.socialnetwork.domain.posts

import io.reactivex.Completable

class DeletePostUseCase(private val repository: PostsRepository) {
    fun execute(id: Int): Completable {
        return repository.deletePost(id)
    }
}