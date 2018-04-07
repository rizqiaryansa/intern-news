package com.rizqiaryansa.internnews.adapter

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.rizqiaryansa.internnews.R
import com.rizqiaryansa.internnews.model.Article
import kotlinx.android.synthetic.main.item_recent_news.view.*
import kotterknife.bindView
import kotterknife.bindViews

class RecentNewsAdapterKt (
        val context: Context,
        val listRecent: List<Article>
        ) : RecyclerView.Adapter<RecentNewsAdapterKt.RecentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentViewHolder {
        return RecentViewHolder(LayoutInflater.from(context).
                inflate(R.layout.item_recent_news, parent, false))
    }

    override fun getItemCount(): Int {
        return listRecent.size
    }

    override fun onBindViewHolder(holder: RecentViewHolder, position: Int) {
        val recentNews: Article = listRecent[position]

        Glide.with(context).load(recentNews.urlToImage)
                .into(holder?.img_recent)

        holder?.title_recent.text = recentNews.title
        holder?.author_recent.text = recentNews.author
        holder?.cvRecent?.setOnClickListener{
            Toast.makeText(context, "Clicked " + recentNews.title,
                    Toast.LENGTH_SHORT).show()
        }

    }


    class RecentViewHolder(internal var rootView: View) : RecyclerView.ViewHolder(rootView) {

        val cvRecent: CardView by bindView(R.id.cv_recent)
        val img_recent: ImageView by bindView(R.id.iv_recentNews)
        val title_recent: TextView by bindView(R.id.tv_title_recent)
        val author_recent: TextView by bindView(R.id.tv_author_recent)
    }
}