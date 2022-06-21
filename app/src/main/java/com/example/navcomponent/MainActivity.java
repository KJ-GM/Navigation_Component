package com.example.navcomponent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private NavController navController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavView);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        Set<Integer> fragmentSet = new HashSet<>();
        fragmentSet.add(R.id.homeFragment);
        fragmentSet.add(R.id.dashboardFragment);
        fragmentSet.add(R.id.notificationFragment);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(fragmentSet).build();

        NavigationUI.setupActionBarWithNavController(this, navController,appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);
    }
}