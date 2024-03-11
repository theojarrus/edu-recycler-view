package ru.tinkoff.recyclerviewapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.util.ArrayList;
import java.util.List;

import ru.tinkoff.recyclerviewapp.databinding.ItemUserBinding;

public class UserAdapter extends Adapter<UserViewHolder> {

    private UserItemClickListener userItemClickListener;
    private List<User> users = new ArrayList<>();

    public void setUserItemClickListener(UserItemClickListener userItemClickListener) {
        this.userItemClickListener = userItemClickListener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemUserBinding binding = ItemUserBinding.inflate(inflater, parent, false);
        return new UserViewHolder(binding, userItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = users.get(position);
        holder.bind(user);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void setItems(List<User> users) {
        int itemCount = getItemCount();
        this.users = new ArrayList<>(users);
        notifyItemRangeChanged(0, Math.max(itemCount, getItemCount()));
    }

    public void removeItem(User user) {
        int position = this.users.indexOf(user);
        this.users.remove(user);
        notifyItemRemoved(position);
    }
}
