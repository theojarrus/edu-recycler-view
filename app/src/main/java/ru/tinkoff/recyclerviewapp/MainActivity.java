package ru.tinkoff.recyclerviewapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

import ru.tinkoff.recyclerviewapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private List<User> users = new UserFactory().createUsers();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        UserAdapter adapter = new UserAdapter();
        UserItemClickListener userItemClickListener = user -> adapter.removeItem(user);
        adapter.setUserItemClickListener(userItemClickListener);
        binding.recycler.setAdapter(adapter);
        adapter.setItems(users);
    }
}
