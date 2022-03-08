package io.kiwik.reign.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.observe
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import io.kiwik.dein.namedViewModel
import io.kiwik.reign.databinding.ActivityMainBinding
import io.kiwik.reign.domain.entities.Post
import io.kiwik.reign.ui.adapter.PostListAdapter
import io.kiwik.reign.ui.adapter.SwipeItemAdapter
import io.kiwik.reign.ui.listener.PostViewListener
import io.kiwik.reign.viewmodel.PostViewModel

class MainActivity : BaseActivity(), PostViewListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PostListAdapter
    private val postViewModel: PostViewModel by namedViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        initializeAdapter()
        initializeRefreshLayout()
        getDataFromServer()
        initializeViewModelListener()
        getDataFromRoom()
        initializeActions()
    }

    private fun initializeActions() {
        binding.swipeRefresh.setOnRefreshListener {
            getDataFromServer()
        }
    }

    private fun getDataFromRoom() {
        postViewModel.getPost().observe(this) {
            adapter.submitList(it)
        }
    }

    private fun initializeViewModelListener() {
        postViewModel.setListenerViewPost(this)
    }

    private fun getDataFromServer() {
        postViewModel.getPostFromServer()
    }

    override fun onSuccessGetPost() {
        runOnUiThread {
            binding.swipeRefresh.isRefreshing = false
        }
    }

    override fun onErrorGetPost() {
        runOnUiThread {
            binding.swipeRefresh.isRefreshing = false
            showMessage("Error al obtener los datos.")
        }
    }

    private fun initializeRefreshLayout() {
        binding.swipeRefresh.setOnRefreshListener {
            init()
            binding.swipeRefresh.isRefreshing = false
        }
    }

    private fun initializeAdapter() {
        adapter = PostListAdapter()
        binding.rvPost.adapter = adapter

        setSwipeAdapter()

        adapter.setOnItemClickListener {
            session.values.currentPost = it
            session.update()
            startActivity(Intent(this, WebViewActivity::class.java))
        }

        adapter.setOnDeleteItemListener { pos, item ->
            postViewModel.removePost(item.storyId)
            showSnackToRestore(pos, item)
        }
    }

    private fun setSwipeAdapter() {
        val swipeItemAdapter = object : SwipeItemAdapter(this) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                when (direction) {
                    ItemTouchHelper.LEFT -> {
                        adapter.deleteItem(viewHolder.bindingAdapterPosition)
                    }
                    else -> Unit
                }
            }
        }
        val touchHelper = ItemTouchHelper(swipeItemAdapter)
        touchHelper.attachToRecyclerView(binding.rvPost)
    }

    private fun showSnackToRestore(pos: Int, item: Post) {
        Snackbar.make(
            binding.root,
            "¿Quieres restaurar la publicación eliminada?",
            Snackbar.LENGTH_LONG
        )
            .setAction("Restaurar") {
                adapter.restoreItem(pos, item)
                postViewModel.insertPost(item)
            }
            .show()
    }

}