package sd.lemon.socialnetwork.presentation.main.di

import dagger.Component
import sd.lemon.socialnetwork.presentation.app.di.AppComponent
import sd.lemon.socialnetwork.presentation.app.di.PerActivity
import sd.lemon.socialnetwork.presentation.main.MainActivity

@Component(modules = [MainModule::class], dependencies = [AppComponent::class])
@PerActivity
interface MainComponent {
    fun inject(mainActivity: MainActivity)
}