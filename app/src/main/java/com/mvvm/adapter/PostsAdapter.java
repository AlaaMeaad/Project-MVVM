package com.mvvm.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mvvm.R;
import com.mvvm.databinding.PostItemBinding;
import com.mvvm.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;



public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private Context context;
    private List<PostModel> modelList ;

    public PostsAdapter( Context context, List<PostModel> modelList) {

        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        PostItemBinding postItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.post_item ,parent ,false );

        return new ViewHolder(postItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PostModel currentitem =modelList.get(position);
        holder.postItemBinding.setModelViewPost(currentitem);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        PostItemBinding postItemBinding;

        public ViewHolder(PostItemBinding itemview) {
            super(itemview.getRoot());
            postItemBinding = itemview;

        }
    }
    public void  setModelList(List mylist){
        modelList=mylist;
        notifyDataSetChanged();

    }
}
