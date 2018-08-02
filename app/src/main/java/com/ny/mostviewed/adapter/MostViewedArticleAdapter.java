package com.ny.mostviewed.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ny.mostviewed.R;
import com.ny.mostviewed.activity.DetailActivity;
import com.ny.mostviewed.model.MostViewedArticle;

import java.text.MessageFormat;
import java.util.List;

public class MostViewedArticleAdapter extends RecyclerView.Adapter<MostViewedArticleAdapter.ViewHolder> {

    private List<MostViewedArticle> mMostViewedArticleList;
    private Context mContext;

    public MostViewedArticleAdapter(Context context, List<MostViewedArticle> mostViewedArticleList) {
        this.mContext = context;
        this.mMostViewedArticleList = mostViewedArticleList;
    }

    @NonNull
    @Override
    public MostViewedArticleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_most_viewed, parent, false);
        return new MostViewedArticleAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MostViewedArticleAdapter.ViewHolder holder, int position) {
        holder.mostViewedArticle = mMostViewedArticleList.get(position);
        if (mMostViewedArticleList.get(position).getMedia() != null && !mMostViewedArticleList.get(position).getMedia().isEmpty() &&
                mMostViewedArticleList.get(position).getMedia().get(0).getMediaMetaDataList() != null &&
                !mMostViewedArticleList.get(position).getMedia().get(0).getMediaMetaDataList().isEmpty()) {
            Glide.with(holder.imageView.getContext())
                    .load(mMostViewedArticleList.get(position).getMedia().get(0).getMediaMetaDataList().get(1).getUrl())
                    .into(holder.imageView);
        }
        holder.tvTitle.setText(mMostViewedArticleList.get(position).getTitle());
        holder.tvAuthor.setText(mMostViewedArticleList.get(position).getAuthor());

        holder.tvDate.setText(MessageFormat.format(mContext.getString(R.string.published_date), mMostViewedArticleList.get(position).getPublishedDate()));

        holder.row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("url", holder.mostViewedArticle.getUrl());

                    context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMostViewedArticleList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final View row;
        private final ImageView imageView;
        private final TextView tvTitle;
        private final TextView tvAuthor;
        private final TextView tvDate;
        private MostViewedArticle mostViewedArticle;

        private ViewHolder(View view) {
            super(view);
            row = view;
            imageView = view.findViewById(R.id.imageView);
            tvTitle = view.findViewById(R.id.tvTitle);
            tvAuthor = view.findViewById(R.id.tvAuthor);
            tvDate = view.findViewById(R.id.tvDate);
        }
    }
}
