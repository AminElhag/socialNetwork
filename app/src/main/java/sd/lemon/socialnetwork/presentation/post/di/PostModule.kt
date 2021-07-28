package sd.lemon.socialnetwork.presentation.post.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import sd.lemon.socialnetwork.data.posts.PostsApiImpl
import sd.lemon.socialnetwork.data.posts.PostsRetrofitService
import sd.lemon.socialnetwork.domain.posts.*
import sd.lemon.socialnetwork.presentation.app.di.PerActivity
import sd.lemon.socialnetwork.presentation.post.PostPresenter
import sd.lemon.socialnetwork.presentation.post.PostView

@Module
class PostModule(private val view: PostView) {

    @Provides
    @PerActivity
    fun providesPostRetrofitService(retrofit: Retrofit): PostsRetrofitService =
        retrofit.create(PostsRetrofitService::class.java)

    @Provides
    @PerActivity
    fun providePostRepository(postsRetrofitService: PostsRetrofitService): PostsRepository =
        PostsApiImpl(postsRetrofitService)

    @Provides
    @PerActivity
    fun provideGetCommentUseCase(postsRepository: PostsRepository): GetCommentUseCase =
        GetCommentUseCase(postsRepository)

    @Provides
    @PerActivity
    fun provideGetOnePostUseCase(postsRepository: PostsRepository): GetOnePostUseCase =
        GetOnePostUseCase(postsRepository)


    @Provides
    @PerActivity
    fun providePostPresenter(
        getOnePostUseCase: GetOnePostUseCase,
        getCommentUseCase: GetCommentUseCase,
        ): PostPresenter =
        PostPresenter(view, getOnePostUseCase, getCommentUseCase)
}