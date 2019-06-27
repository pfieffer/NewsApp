package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.newsapp.viewModel.NewsViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.adapters.NewsAdapter
import com.example.newsapp.model.Article
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.model.NewsResponse


class MainActivity : AppCompatActivity(), View.OnClickListener {

    var articleList: List<Article> = ArrayList()

    var newsAdapter: NewsAdapter? = null
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpRecyclerView()

        val newsViewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)

        newsViewModel.getNewsRepository().observe(this, Observer<NewsResponse>{
            this@MainActivity.articleList = it.articles
//            for(article in articleList)
//                Log.d("MainActivity", article.title)
//            newsAdapter?.notifyDataSetChanged()
            newsAdapter = NewsAdapter(this@MainActivity.articleList, this@MainActivity)
            recyclerView.adapter = newsAdapter
        })

    }

    private fun setUpRecyclerView() {
        recyclerView = findViewById(R.id.rv_news)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.isNestedScrollingEnabled = true
    }

    override fun onClick(p0: View?) {
        Toast.makeText(this, "HELLO", Toast.LENGTH_SHORT).show()
    }
}
