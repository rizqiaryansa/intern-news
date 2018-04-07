package com.rizqiaryansa.internnews.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.rizqiaryansa.internnews.DetailActivity
import com.rizqiaryansa.internnews.R
import com.rizqiaryansa.internnews.model.Article
import com.rizqiaryansa.internnews.model.News
import com.rizqiaryansa.internnews.model.Source
import kotlinx.android.synthetic.main.item_recent_news.view.*
import kotterknife.bindView
import kotterknife.bindViews
import android.app.Activity



class RecentNewsAdapterKt (
        val activity: Activity,
        val listRecent: List<Article>
        ) : RecyclerView.Adapter<RecentNewsAdapterKt.RecentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentViewHolder {
        return RecentViewHolder(LayoutInflater.from(activity).
                inflate(R.layout.item_recent_news, parent, false))
    }

    override fun getItemCount(): Int {
        return listRecent.size
    }

    override fun onBindViewHolder(holder: RecentViewHolder, position: Int) {
        val recentNews: Article = listRecent[position]

        val sourceNews: Source = recentNews.source!!

        Glide.with(activity).load(recentNews.urlToImage)
                .into(holder?.img_recent)

        holder?.title_recent.text = recentNews.title
        holder?.author_recent.text = recentNews.author
        holder?.cvRecent?.setOnClickListener{

            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra(DetailActivity.titleNews, recentNews.title)
            intent.putExtra(DetailActivity.authorNews, recentNews.author)
            intent.putExtra(DetailActivity.imgNews, recentNews.urlToImage)
            intent.putExtra(DetailActivity.timeNews, recentNews.publishedAt)
            intent.putExtra(DetailActivity.sourceNews, sourceNews.name)
            intent.putExtra(DetailActivity.descNews, recentNews.description)

            activity.overridePendingTransition(R.transition.fade_in, R.transition.fade_out);

            activity.startActivity(intent)
        }

    }


    class RecentViewHolder(internal var rootView: View) : RecyclerView.ViewHolder(rootView) {

        val cvRecent: CardView by bindView(R.id.cv_recent)
        val img_recent: ImageView by bindView(R.id.iv_recentNews)
        val title_recent: TextView by bindView(R.id.tv_title_recent)
        val author_recent: TextView by bindView(R.id.tv_author_recent)
    }
}