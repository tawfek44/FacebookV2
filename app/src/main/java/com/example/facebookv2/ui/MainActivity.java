package com.example.facebookv2.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.facebookv2.R;
import com.example.facebookv2.pojo.PostModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    postViewModel postViewModel;
    RecyclerView postRec;
    postAdapter postAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postViewModel= ViewModelProviders.of(this).get(com.example.facebookv2.ui.postViewModel.class);
        postViewModel.getposts();
        postRec=findViewById(R.id.post_recycler);
        postAdapter=new postAdapter();
        postRec.setLayoutManager(new LinearLayoutManager(this));
        postRec.setAdapter(postAdapter);
        postViewModel.posts.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                postAdapter.setList(postModels);
            }
        });
    }
}