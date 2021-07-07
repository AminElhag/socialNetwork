package sd.lemon.socialnetwork.presentation.main.di

import dagger.Component
import sd.lemon.socialnetwork.presentation.main.MainActivity

@Component(modules = [MainModule::class])
@PerActivity
interface MainComponent {
    fun inject(mainActivity: MainActivity)
}