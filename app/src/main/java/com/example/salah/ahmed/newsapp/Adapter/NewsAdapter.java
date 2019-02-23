package com.example.salah.ahmed.newsapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.salah.ahmed.newsapp.Model.Article;
import com.example.salah.ahmed.newsapp.R;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    private     List<Article> mNewsList;
    private Context mContext;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public NewsAdapter(Context context, List<Article> moviesList) {
        this.mNewsList = moviesList;
        this.mContext = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext)
                .inflate(R.layout.news_list, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Article news = mNewsList.get(position);

        holder.title_news.setText(news.getTitle());
        holder.date_news.setText(news.getPublishedAt());

//        Log.v("img", String.valueOf( mNewsList.get(position).getUrlToImage()));

        Glide.with(mContext)
                .load(mNewsList.get(position).getUrlToImage())
                .centerCrop()
//                .placeholder(R.drawable.loading_spinner)
                .into(holder.img_news);
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_news;
        private TextView title_news, date_news;

        public MyViewHolder(View itemView) {
            super(itemView);
            img_news = itemView.findViewById(R.id.news_img);
            title_news = itemView.findViewById(R.id.news_title);
            date_news = itemView.findViewById(R.id.news_date);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }


}
