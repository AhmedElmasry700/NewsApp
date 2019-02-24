package com.example.salah.ahmed.newsapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.salah.ahmed.newsapp.Model.DbNews;
import com.example.salah.ahmed.newsapp.R;

import java.util.List;

public class FavoAdapter extends RecyclerView.Adapter<FavoAdapter.MyViewHolder> {
    private List<DbNews> mNewsList;
    private Context mContext;
    private FavoAdapter.OnItemClickListener mListener;

    public FavoAdapter(Context context, List<DbNews> moviesList) {
        this.mNewsList = moviesList;
        this.mContext = context;
    }

    public void setOnItemClickListener(FavoAdapter.OnItemClickListener listener) {
        mListener = listener;
    }

    public void setTasks(List<DbNews> taskEntries) {
        mNewsList = taskEntries;
        notifyDataSetChanged();
    }

    @Override
    public FavoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext)
                .inflate(R.layout.news_list, parent, false);

        return new FavoAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FavoAdapter.MyViewHolder holder, int position) {
        DbNews news = mNewsList.get(position);

        holder.title_news.setText(news.getDb_newsTitle());
//        holder.date_news.setText(news.getPublishedAt());

//        Log.v("img", String.valueOf( mNewsList.get(position).getUrlToImage()));

        Glide.with(mContext)
                .load(mNewsList.get(position).getDb_newsPster())
                .centerCrop()
//                .placeholder(R.drawable.loading_spinner)
                .into(holder.img_news);
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
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
