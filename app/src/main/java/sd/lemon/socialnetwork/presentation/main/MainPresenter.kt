package sd.lemon.socialnetwork.presentation.main

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import sd.lemon.socialnetwork.domain.posts.CratePostUseCase
import sd.lemon.socialnetwork.domain.posts.GetPostsUseCase
import sd.lemon.socialnetwork.domain.posts.models.Post

class MainPresenter(
    private val view: MainView,
    private val getPostsUseCase: GetPostsUseCase,
    private val createPostUseCase: CratePostUseCase,
) {

    private val compositeDisposable = CompositeDisposable()

    fun getPost() {
        val subscribeOn = getPostsUseCase.execute().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                it?.let {
                    view.getPost(it)
                }
            }, {
                view.error(it)
            })

        compositeDisposable.add(subscribeOn)
    }

    fun postFieldChange(post: String) {
        view.togglePostButton(post.length >= 5)
    }

    fun onSubmitPost(post: String) {
        view.toggleProgressMessage(true)
        val subscribe =
            createPostUseCase.execute(Post(1, 1, "Title", post)).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.postCreated()
                    view.clarePostFielded()
                    getPost()
                    view.toggleProgressMessage(false)
                }, {
                    view.error(it)
                    view.toggleProgressMessage(false)
                })

        compositeDisposable.add(subscribe)
    }

    fun onDestroy() {
        compositeDisposable.clear()
    }
}