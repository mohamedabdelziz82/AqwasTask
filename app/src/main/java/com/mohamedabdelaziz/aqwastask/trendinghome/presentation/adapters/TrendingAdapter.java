package com.mohamedabdelaziz.aqwastask.trendinghome.presentation.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mohamedabdelaziz.aqwastask.R;
import com.mohamedabdelaziz.aqwastask.databinding.TrendingItemBinding;
import com.mohamedabdelaziz.aqwastask.trendinghome.domain.model.TrendingResponse;

import java.util.ArrayList;
import java.util.List;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.TrendingHolder> {
    private List<TrendingResponse> trendingList = new ArrayList<>();
    private final Context context;

    public TrendingAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public TrendingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TrendingItemBinding trendingItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.trending_item, parent, false);
        return new TrendingHolder(trendingItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingHolder holder, int position) {
        TrendingResponse trendingResponse = trendingList.get(position);
        //parent item
        holder.trendingItemBinding.nameTv.setText(trendingResponse.getName());
        holder.trendingItemBinding.authorTv.setText(trendingResponse.getAuthor());
        Glide.with(context).load(trendingResponse.getAvatar())
                .circleCrop()
                .into(holder.trendingItemBinding.imageView);
        //expended item
        holder.trendingItemBinding.descriptionTv.setText(trendingResponse.getDescription());
        holder.trendingItemBinding.languageTv.setText(trendingResponse.getLanguage());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(trendingResponse.getLanguageColor()));
        gradientDrawable.setSize(25, 25);
        holder.trendingItemBinding.languageColorImageView.setImageDrawable(gradientDrawable);
        holder.trendingItemBinding.starTv.setText(String.valueOf(trendingResponse.getStars()));
        holder.trendingItemBinding.forkTv.setText(String.valueOf(trendingResponse.getForks()));
        holder.itemView.setOnClickListener(v -> {

            if (holder.trendingItemBinding.subDetailsConstraintLayout.getVisibility() == View.GONE) {
                holder.trendingItemBinding.subDetailsConstraintLayout.setVisibility(View.VISIBLE);
                holder.trendingItemBinding.trendItemCardView.setCardBackgroundColor(context.getResources().getColor(R.color.selected_color));
            } else if (holder.trendingItemBinding.subDetailsConstraintLayout.getVisibility() == View.VISIBLE) {
                holder.trendingItemBinding.subDetailsConstraintLayout.setVisibility(View.GONE);
                holder.trendingItemBinding.trendItemCardView.setCardBackgroundColor(context.getResources().getColor(R.color.white));

            }
        });


    }


    @Override
    public int getItemCount() {
        return trendingList != null ? trendingList.size() : 0;
    }

    public void setList(List<TrendingResponse> trendingList) {
        this.trendingList = trendingList;
        notifyDataSetChanged();
    }

   static class  TrendingHolder extends RecyclerView.ViewHolder {
        TrendingItemBinding trendingItemBinding;

        public TrendingHolder(@NonNull TrendingItemBinding itemView) {
            super(itemView.getRoot());
            trendingItemBinding = itemView;
        }
    }

    public void clear() {
        trendingList.clear();
        while (getItemCount() > 0) {
            remove(getItem(0));
            notifyDataSetChanged();
        }
        notifyDataSetChanged();

    }

    public void remove(TrendingResponse trendingResponse) {
        int position = trendingList.indexOf(trendingResponse);
        if (position > -1) {
            trendingList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public TrendingResponse getItem(int position) {
        return trendingList.get(position);
    }

}
