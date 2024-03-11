package ru.tinkoff.recyclerviewapp;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.bumptech.glide.Glide;

import ru.tinkoff.recyclerviewapp.databinding.ItemUserBinding;

public class UserViewHolder extends ViewHolder {

    private ItemUserBinding binding;
    private UserItemClickListener userItemClickListener;

    public UserViewHolder(ItemUserBinding binding, UserItemClickListener userItemClickListener) {
        super(binding.getRoot());
        this.binding = binding;
        this.userItemClickListener = userItemClickListener;
    }

    public void bind(User item) {
        // Set text data
        binding.name.setText(item.getName());
        binding.email.setText(item.getEmail());
        // Load image
        Glide.with(itemView)
                .load(item.getAvatar())
                .placeholder(R.mipmap.ic_launcher)
                .into(binding.avatar);
        // Set Listener
        binding.getRoot().setOnClickListener(v -> userItemClickListener.onItemClick(item));
    }
}
