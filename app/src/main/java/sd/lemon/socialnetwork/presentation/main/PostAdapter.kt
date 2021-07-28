package sd.lemon.socialnetwork.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sd.lemon.socialnetwork.R
import sd.lemon.socialnetwork.domain.posts.models.Post


class PostAdapter(private val dataModules: List<Post>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterLayoutInflater =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return ViewHolder(adapterLayoutInflater)
    }

    private lateinit var actionsListener: OnActionsListener

    fun setOnActionsListener(actionsListener: OnActionsListener){
        this.actionsListener = actionsListener
    }

    override fun getItemCount(): Int {
        return dataModules.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataModules[position]
        "Title: ${item.title}".also { holder.title.text = it }
        holder.body.text = item.body
        holder.itemView.setOnClickListener {
            actionsListener.onPostClicked(dataModules[position])
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.textViewTaskTitle)
        val body: TextView = view.findViewById(R.id.textViewTaskBody)
    }

    interface OnActionsListener{
        fun onPostClicked(post: Post)
    }

}