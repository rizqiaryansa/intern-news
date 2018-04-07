package com.rizqiaryansa.internnews.adapter

import android.app.Activity
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
import com.rizqiaryansa.internnews.model.Source
import kotlinx.android.synthetic.main.item_headline_news.view.*
import kotterknife.bindView


class HeadlineNewsAdapterKt (
        val activity: Activity,
        val listHeadline: List<Article>
        ): RecyclerView.Adapter<HeadlineNewsAdapterKt.HeadlineViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadlineViewHolder {
        val view = LayoutInflater.from(activity)
                .inflate(R.layout.item_headline_news, parent, false)
        return HeadlineViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHeadline.size
    }

    override fun onBindViewHolder(holder: HeadlineViewHolder, position: Int) {
        val headlineNews: Article = listHeadline[position]
        val sourceNews: Source = headlineNews.source!!

        Glide.with(activity).load(headlineNews.urlToImage)
                .into(holder?.img_headline)

        holder?.title_headline.text = headlineNews.title
        holder?.author_headline.text = headlineNews.author

        holder?.cvHeadline?.setOnClickListener {
            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra(DetailActivity.titleNews, headlineNews.title)
            intent.putExtra(DetailActivity.authorNews, headlineNews.author)
            intent.putExtra(DetailActivity.imgNews, headlineNews.urlToImage)
            intent.putExtra(DetailActivity.timeNews, headlineNews.publishedAt)
            intent.putExtra(DetailActivity.sourceNews, sourceNews.name)
            intent.putExtra(DetailActivity.descNews, headlineNews.description)

            activity.overridePendingTransition(R.transition.fade_in, R.transition.fade_out);

            activity.startActivity(intent)
        }
    }


    inner class HeadlineViewHolder(rootView: View) :
            RecyclerView.ViewHolder(rootView) {

        val cvHeadline: CardView = itemView.cv_headline
        val img_headline: ImageView = itemView.iv_newsHeadline
        val title_headline: TextView = itemView.tvTitleHeadline
        val author_headline: TextView = itemView.tvAuthorHeadline
    }

}