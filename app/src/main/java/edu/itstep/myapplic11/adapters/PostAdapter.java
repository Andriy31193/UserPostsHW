package edu.itstep.myapplic11.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.itstep.myapplic11.models.Post;
import edu.itstep.myapplic11.R;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private final List<Post> posts;
    private final OnItemClickListener listener;

    public PostAdapter(List<Post> posts, OnItemClickListener listener) {
        this.posts = posts;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.bind(post, listener);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public interface OnItemClickListener {
        void onItemClick(Post post);
    }

    static class PostViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvTitle;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
        }

        public void bind(Post post, OnItemClickListener listener) {
            tvTitle.setText(post.getTitle());
            itemView.setOnClickListener(v -> listener.onItemClick(post));
        }
    }
}
