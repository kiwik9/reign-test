package io.kiwik.reign.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.kiwik.reign.databinding.PostItemBinding
import io.kiwik.reign.domain.entities.Post
import io.kiwik.reign.ui.OnDeleteItemListener
import io.kiwik.reign.ui.OnItemClickListener

class PostListAdapter :
    RecyclerView.Adapter<PostListAdapter.ViewHolder>() {

    private val list = mutableListOf<Post>()
    private var mListener: OnItemClickListener<Post>? = null
    private var deleteItemListener: OnDeleteItemListener<Post>? = null

    private lateinit var mLayoutInflater: LayoutInflater

    fun submitList(data: List<Post>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(listener: OnItemClickListener<Post>) {
        mListener = listener
    }

    fun setOnDeleteItemListener(listener: OnDeleteItemListener<Post>) {
        deleteItemListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (!::mLayoutInflater.isInitialized) {
            mLayoutInflater = LayoutInflater.from(parent.context)
        }
        val binding = PostItemBinding.inflate(mLayoutInflater, parent, false)
        return ViewHolder(binding, binding.root)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(list[position])

    inner class ViewHolder(private val binding: PostItemBinding, itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        @SuppressLint("ClickableViewAccessibility", "SetTextI18n")
        fun bind(item: Post) {
            binding.root.setOnClickListener {
                mListener?.invoke(item)
            }

            binding.txtTitle.text = item.storyTitle
            binding.txtAuthor.text = item.author
            binding.txtDate.text = item.getDifDate()

        }
    }

    fun deleteItem(pos: Int) {
        val post = list[pos]
        list.removeAt(pos)
        notifyItemRemoved(pos)
        deleteItemListener?.invoke(pos, post)
    }

    fun restoreItem(pos: Int, item: Post) {
        list.add(pos, item)
        notifyItemInserted(pos)
    }
}