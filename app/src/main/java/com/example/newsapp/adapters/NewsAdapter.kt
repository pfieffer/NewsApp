package com.example.newsapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.model.Article
import com.squareup.picasso.Picasso

class NewsAdapter(private var  newsList: List<Article>, var clickListener: View.OnClickListener) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false))
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = newsList[position]
        holder.tvName.text = article.title
        holder.tvDescription.text = article.description

        if(article.urlToImage.isNotEmpty()){
            Picasso.get().load(article.urlToImage).into(holder.ivNews)
        }
    }

    fun getNews(adapterPosition: Int): Article {
        return newsList[adapterPosition]
    }


    inner class NewsViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView
        var tvDescription: TextView
        var ivNews: ImageView

        init {
            itemView.setOnClickListener(clickListener)
            itemView.tag = this

            tvName = itemView.findViewById(R.id.tv_title) as TextView
            tvDescription = itemView.findViewById(R.id.tv_description) as TextView
            ivNews = itemView.findViewById(R.id.iv_news) as ImageView
        }
    }

}
