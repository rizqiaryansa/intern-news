package com.rizqiaryansa.internnews

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_headline_news.*

class DetailActivity : AppCompatActivity() {

    companion object {
        val titleNews = "titleNews"
        val sourceNews = "sourceNews"
        val authorNews = "authorNews"
        val timeNews = "timeNews"
        val descNews = "descNews"
        val imgNews = "imgNews"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        if(intent.extras != null) {
            val title = intent.getStringExtra(titleNews)
            val source = intent.getStringExtra(sourceNews)
            val author = intent.getStringExtra(authorNews)
            val time = intent.getStringExtra(timeNews)
            val desc = intent.getStringExtra(descNews)
            val img = intent.getStringExtra(imgNews)

            supportActionBar?.title = "TechCrunch"

            tv_source.text = source
            tv_title.text = title
            tv_author.text = author
            tv_time_publisher.text = time
            tv_description.text = desc

            Glide.with(this)
                    .load(img)
                    .into(ivNewsDetail)
        }
    }
}
