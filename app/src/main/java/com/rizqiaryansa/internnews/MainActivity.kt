package com.rizqiaryansa.internnews

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.rizqiaryansa.internnews.adapter.HeadlineNewsAdapterKt
import com.rizqiaryansa.internnews.adapter.RecentNewsAdapterKt
import com.rizqiaryansa.internnews.model.Article
import com.rizqiaryansa.internnews.model.News
import com.rizqiaryansa.internnews.network.ApiClient
import com.rizqiaryansa.internnews.network.ApiInterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val api_key = "ISI API KEY"
    private val serviceNews = ApiClient.getClient()?.create(ApiInterface::class.java)

    private lateinit var recylerViewHeadline: RecyclerView
    lateinit var recyclerViewRecent: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recylerViewHeadline = findViewById(R.id.rvHeadline)
        recyclerViewRecent = findViewById(R.id.rvRecent)

        recyclerViewRecent.layoutManager = LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false)

        recylerViewHeadline.layoutManager = LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false)

        progressBar.visibility = View.VISIBLE

        callFetchHeadline()
        callFetchRecent()
    }

    fun callFetchHeadline() {

        val call = serviceNews?.getHeadlines("techcrunch", api_key)

        call?.enqueue(object : Callback<News> {

            override fun onResponse(call: Call<News>?, response: Response<News>?) {
                if(response?.body().toString() != null) {

                    var listHeadline: List<Article>? = response?.body()?.articles
                    recylerViewHeadline.adapter = HeadlineNewsAdapterKt(this@MainActivity,
                            listHeadline!!)
                    tvRecent.visibility = View.VISIBLE
                }
            }

            override fun onFailure(call: Call<News>?, t: Throwable?) {
                Log.d("errorHeadline", t.toString())
            }
        })

    }

    fun callFetchRecent() {

        val call = serviceNews?.getRecents("techcrunch", api_key)

        call?.enqueue(object : Callback<News> {

            override fun onResponse(call: Call<News>?, response: Response<News>?) {

                var listRecent: List<Article>? = response?.body()?.articles
                recyclerViewRecent.adapter = RecentNewsAdapterKt(this@MainActivity,
                        listRecent!!)
                progressBar.visibility = View.GONE
            }

            override fun onFailure(call: Call<News>?, t: Throwable?) {
                Log.d("errorRecent", t.toString())
            }
        })
    }
}
