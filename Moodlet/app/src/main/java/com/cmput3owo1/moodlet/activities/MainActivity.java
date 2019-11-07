package com.cmput3owo1.moodlet.activities;

import android.os.Bundle;

import com.cmput3owo1.moodlet.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView historyRecyclerView;
    RecyclerView.Adapter historyAdapter;
    RecyclerView.LayoutManager historyLayoutManager;

    List<String> moodhistoryDataSet = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_mood_history, R.id.navigation_feed, R.id.navigation_search,
                R.id.navigation_map)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


        for(int i = 0; i < 10; i++) {
            moodhistoryDataSet.add("Mood history " + Integer.toString(i+1));
        }

        historyLayoutManager = new LinearLayoutManager(this);
        historyAdapter = new historyAdapter(moodhistoryDataSet);

        historyRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        historyRecyclerView.setLayoutManager(historyLayoutManager);
        historyRecyclerView.setAdapter(historyAdapter);



    }

}
