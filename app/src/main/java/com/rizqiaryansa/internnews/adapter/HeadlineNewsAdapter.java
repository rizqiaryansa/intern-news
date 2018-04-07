package com.rizqiaryansa.internnews.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rizqiaryansa.internnews.R;
import com.rizqiaryansa.internnews.model.Article;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HeadlineNewsAdapter extends RecyclerView.Adapter<HeadlineNewsAdapter.
        HeadlineViewHolder> {

    private Context context;
    private List<Article> mArticle;

    public HeadlineNewsAdapter(Context context, List<Article> mArticle) {
        this.context = context;
        this.mArticle = mArticle;
    }

    @Override
    public HeadlineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_headline_news,
                parent, false);
        return new HeadlineViewHolder(v);
    }

    @Override
    public void onBindViewHolder(HeadlineViewHolder holder, int position) {

        holder.tvTitleHeadline.setText(mArticle.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mArticle.size();
    }

    class HeadlineViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cv_headline)
        CardView cvHeadline;
        @BindView(R.id.iv_newsHeadline)
        ImageView ivHeadline;
        @BindView(R.id.tvTitleHeadline)
        TextView tvTitleHeadline;

        public HeadlineViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
