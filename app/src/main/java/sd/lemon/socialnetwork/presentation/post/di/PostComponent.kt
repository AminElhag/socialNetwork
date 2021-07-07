package sd.lemon.socialnetwork.presentation.post.di

import dagger.Component
import sd.lemon.socialnetwork.presentation.post.PostActivity

@Component(modules = [PostModule::class])
@PerActivity
interface PostComponent {
    fun inject(postActivity: PostActivity)
}