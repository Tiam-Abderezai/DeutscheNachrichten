package com.example.deutschenachrichten.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.deutschenachrichten.data.model.Article
import com.example.deutschenachrichten.databinding.ItemArticleBinding
import com.example.deutschenachrichten.ui.view.ListFragmentDirections
import kotlinx.android.synthetic.main.item_article.view.*
import javax.inject.Inject

class ArticleAdapter @Inject constructor(
) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {
    private val articles = mutableListOf<Article>()
    private val TAG = "ArticleAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun getItemCount(): Int = articles.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val item = articles[position]
        Log.d(TAG, "onBindViewHolder: $item")
        holder.bind(item)
        val action =
            item.let {
                ListFragmentDirections.actionListFragmentToDetailFragment(
                    it
                )
            }
        holder.itemView.setOnClickListener {
            action.let { NewsResponse -> it.findNavController().navigate(NewsResponse) }
//            Toast.makeText(holder.itemView.context, articles[position], Toast.LENGTH_SHORT).show()
        }
    }

    class ArticleViewHolder(itemView: ItemArticleBinding) : RecyclerView.ViewHolder(itemView.root) {
        private val TAG = "ArticleViewHolder"
            fun bind(article: Article) {
            val title = article.title.toString()
            val source = article.source.name.toString()
            Log.d(TAG, "bind: $title")
            itemView.tv_title.text = title
            itemView.tv_source.text = source.lowercase()
        }
    }

    fun addData(articles: List<Article>) {
        this.articles.apply {
            clear()
            addAll(articles)
            notifyDataSetChanged()
        }
    }
}