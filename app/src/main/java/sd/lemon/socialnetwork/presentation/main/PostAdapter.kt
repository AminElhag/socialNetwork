package sd.lemon.socialnetwork.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sd.lemon.socialnetwork.R
import sd.lemon.socialnetwork.domain.posts.models.Post


class PostAdapter(
    private val dataModules: List<Post>,
    private val clickView: MainView? = null,
) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterLayoutInflater =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return ViewHolder(adapterLayoutInflater)
    }

    override fun getItemCount(): Int {
        return dataModules.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataModules[position]
        "Title: ${item.title}".also { holder.title.text = it }
        holder.body.text = item.body
        holder.itemView.setOnClickListener {
            clickView?.onCellClickListener(dataModules[position])
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tv_title)
        val body: TextView = view.findViewById(R.id.tv_body)
    }


}