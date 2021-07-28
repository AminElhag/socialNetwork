package sd.lemon.socialnetwork.domain.posts

import com.google.gson.annotations.SerializedName
import io.reactivex.Observable
import sd.lemon.socialnetwork.domain.common.UseCase
import sd.lemon.socialnetwork.domain.posts.models.Post

class CreatePostUseCase(private val repository: PostsRepository) : UseCase<CreatePostUseCase.Parameters,Post> {

    override fun execute(parameters: Parameters): Observable<Post> {
        return repository.cratePost(parameters)
    }

    class Parameters (
        @SerializedName("user_id")  val userId: Int,
        val body: String
        ) : UseCase.Parameters
}