package sd.lemon.socialnetwork.presentation.main.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import sd.lemon.socialnetwork.data.posts.PostsApiImpl
import sd.lemon.socialnetwork.data.posts.PostsMemoryImpl
import sd.lemon.socialnetwork.data.posts.PostsRetrofitService
import sd.lemon.socialnetwork.domain.posts.CreatePostUseCase
import sd.lemon.socialnetwork.domain.posts.GetPostsUseCase
import sd.lemon.socialnetwork.domain.posts.PostsRepository
import sd.lemon.socialnetwork.presentation.app.di.PerActivity
import sd.lemon.socialnetwork.presentation.main.MainPresenter
import sd.lemon.socialnetwork.presentation.main.MainView
import javax.inject.Singleton

@Module
class MainModule(private val view: MainView) {

    @Provides
    @PerActivity
    fun providesPostRetrofitService(retrofit: Retrofit): PostsRetrofitService =
        retrofit.create(PostsRetrofitService::class.java)

    @Provides
    @Singleton
    fun providePostRepository(postsRetrofitService: PostsRetrofitService): PostsRepository =
        PostsApiImpl(postsRetrofitService)

    @Provides
    @PerActivity
    fun provideGetPostsUseCase(postsRepository: PostsRepository): GetPostsUseCase =
        GetPostsUseCase(postsRepository)

    @Provides
    @PerActivity
    fun provideCreatePostsUseCase(postsRepository: PostsRepository): CreatePostUseCase =
        CreatePostUseCase(postsRepository)


    @Provides
    @PerActivity
    fun provideMainPresenter(
        getPostsUseCase: GetPostsUseCase,
        createPostUseCase: CreatePostUseCase,
    ): MainPresenter =
        MainPresenter(view, getPostsUseCase, createPostUseCase)

}