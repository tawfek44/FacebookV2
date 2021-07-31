package com.example.facebookv2.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facebookv2.R;
import com.example.facebookv2.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

public class postAdapter extends RecyclerView.Adapter<postAdapter.PostViewHolder> {
    private List<PostModel> postArray=new ArrayList<>();
    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.idTV.setText(String.valueOf(postArray.get(position).getId()));
        holder.titleTV.setText(postArray.get(position).getTitle());
        holder.bodyTV.setText(postArray.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return postArray.size();
    }

    public void setList(List<PostModel> postsList)
    {
        this.postArray=postsList;
        notifyDataSetChanged();
    }
    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView idTV,titleTV,bodyTV;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            idTV=itemView.findViewById(R.id.user_id);
            bodyTV=itemView.findViewById(R.id.body);
            titleTV=itemView.findViewById(R.id.title_id);
        }
    }
}
