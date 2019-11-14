package com.mvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.mvvm.R;
import com.mvvm.adapter.PostsAdapter;
import com.mvvm.databinding.ActivityMainBinding;
import com.mvvm.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    PostViewModel postViewModel;
    PostsAdapter adapter;
    private ActivityMainBinding activityMainBinding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this , R.layout.activity_main);
        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        postViewModel.getPosts();
        postViewModel.postsMutableLiveData.observe(this, new Observer<List<PostModel>>() {
            List<PostModel> mylist = new ArrayList<>();

            @Override
            public void onChanged(List<PostModel> postModels) {
                adapter.setModelList(mylist);

            }
        });
        proprtyRecyclerView();

    }

    private void proprtyRecyclerView() {
        activityMainBinding.recycler.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new PostsAdapter(this);
        activityMainBinding.recycler.setAdapter(adapter);

    }
}
