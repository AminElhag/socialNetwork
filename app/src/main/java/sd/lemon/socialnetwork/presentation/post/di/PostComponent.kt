package sd.lemon.socialnetwork.presentation.post.di

import dagger.Component
import sd.lemon.socialnetwork.presentation.app.di.AppComponent
import sd.lemon.socialnetwork.presentation.app.di.PerActivity
import sd.lemon.socialnetwork.presentation.post.PostActivity

@Component(modules = [PostModule::class], dependencies = [AppComponent::class])
@PerActivity
interface PostComponent {
    fun inject(postActivity: PostActivity)
}