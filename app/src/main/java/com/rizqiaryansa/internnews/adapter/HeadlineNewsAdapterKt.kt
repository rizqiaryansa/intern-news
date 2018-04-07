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
import kotlinx.android.synthetic.main.item_headline_news.view.*
import kotterknife.bindView


class HeadlineNewsAdapterKt (
        val context: Context,
        val listHeadline: List<Article>
        ): RecyclerView.Adapter<HeadlineNewsAdapterKt.HeadlineViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadlineViewHolder {
        val view = LayoutInflater.from(context)
                .inflate(R.layout.item_headline_news, parent, false)
        return HeadlineViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHeadline.size
    }

    override fun onBindViewHolder(holder: HeadlineViewHolder, position: Int) {
        val headlineNews: Article = listHeadline[position]

        Glide.with(context).load(headlineNews.urlToImage)
                .into(holder?.img_headline)

        holder?.title_headline.text = headlineNews.title
        holder?.author_headline.text = headlineNews.author

        holder?.cvHeadline?.setOnClickListener {
            Toast.makeText(context, "Clicked " + headlineNews.title,
                    Toast.LENGTH_SHORT).show()
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