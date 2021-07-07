package sd.lemon.socialnetwork.presentation.post

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import sd.lemon.socialnetwork.domain.posts.GetCommentUseCase
import sd.lemon.socialnetwork.domain.posts.GetOnePostUseCase

class PostPresenter(
    private val view: PostView,
    private val getOnePostUseCase: GetOnePostUseCase,
    private val getCommentUseCase: GetCommentUseCase,
) {

    private var compositeDisposable: CompositeDisposable = CompositeDisposable()
    private var postId: Int? = null


    fun setPostId(postID: Int) {
        postId = postID
    }

    fun showComments() {
        val subscribe = getCommentUseCase.execute(postId!!).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.showComments(it!!)
            }, {
                view.error(it)
            })
        compositeDisposable.add(subscribe)
    }

    fun onDestroy() {
        compositeDisposable.clear()
    }

    fun showPost() {
        postId?.let {
            val subscribe = getOnePostUseCase.execute(it).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({ post ->
                    view.showPost(post)
                }, { throwable ->
                    view.error(throwable)
                })
            compositeDisposable.add(subscribe)
        }

    }
}