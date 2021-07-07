package sd.lemon.socialnetwork.presentation.post.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import sd.lemon.socialnetwork.data.posts.PostsApiImpl
import sd.lemon.socialnetwork.data.posts.PostsRetrofitService
import sd.lemon.socialnetwork.data.posts.RetrofitClient
import sd.lemon.socialnetwork.domain.posts.*
import sd.lemon.socialnetwork.presentation.main.di.PerActivity
import sd.lemon.socialnetwork.presentation.post.PostPresenter
import sd.lemon.socialnetwork.presentation.post.PostView

@Module
class PostModule(private val view: PostView) {

    @Provides
    @sd.lemon.socialnetwork.presentation.post.di.PerActivity
    fun provideRetrofit(): Retrofit =
        RetrofitClient.retrofit

    @Provides
    @sd.lemon.socialnetwork.presentation.post.di.PerActivity
    fun providesPostRetrofitService(retrofit: Retrofit): PostsRetrofitService =
        retrofit.create(PostsRetrofitService::class.java)

    @Provides
    @sd.lemon.socialnetwork.presentation.post.di.PerActivity
    fun providePostRepository(postsRetrofitService: PostsRetrofitService): PostsRepository =
        PostsApiImpl(postsRetrofitService)

    @Provides
    @sd.lemon.socialnetwork.presentation.post.di.PerActivity
    fun provideGetCommentUseCase(postsRepository: PostsRepository): GetCommentUseCase =
        GetCommentUseCase(postsRepository)

    @Provides
    @sd.lemon.socialnetwork.presentation.post.di.PerActivity
    fun provideGetOnePostUseCase(postsRepository: PostsRepository): GetOnePostUseCase =
        GetOnePostUseCase(postsRepository)


    @Provides
    @sd.lemon.socialnetwork.presentation.post.di.PerActivity
    fun providePostPresenter(
        getOnePostUseCase: GetOnePostUseCase,
        getCommentUseCase: GetCommentUseCase,
        ): PostPresenter =
        PostPresenter(view, getOnePostUseCase, getCommentUseCase)
}