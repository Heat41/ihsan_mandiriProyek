package com.example.my_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
//import android.support.v7.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
//        getSupportActionBar().hide();
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);


        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_profile).setVisible(true);



        navigationView.bringToFront();
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_home);
    }

    @Override
    public void onBackPressed(){

        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.nav_home:
                Intent intent = new Intent(Dashboard.this,Dashboard.class);
                break;
            case R.id.nav_network:
                intent = new Intent(Dashboard.this,NetworkActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_security:
                intent = new Intent(Dashboard.this,Security.class);
                startActivity(intent);
                break;
            case R.id.nav_data:
                intent = new Intent(Dashboard.this, DataActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_monitoring:
                intent = new Intent(Dashboard.this, MonitoringActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_uc:
                intent = new Intent(Dashboard.this, UcActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_profile:
                intent = new Intent(Dashboard.this, SecondActivity.class);
                startActivity(intent);
                break;


            case R.id.nav_share:
                Toast.makeText(this, "Share",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_rate:
                Toast.makeText(this, "Rate",Toast.LENGTH_SHORT).show();
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

//Button
    public void SecurityButton(View view) {
        Intent intent = new Intent(this, Security.class);
        startActivity(intent);
    }

    public void NetworkButton(View view) {
        Intent intent = new Intent(this, NetworkActivity.class);
        startActivity(intent);
    }

    public void DataButton(View view) {
        Intent intent = new Intent(this, DataActivity.class);
        startActivity(intent);
    }

    public void MonitoringButton(View view) {
        Intent intent = new Intent(this, MonitoringActivity.class);
        startActivity(intent);
    }

    public void UcButton(View view) {
        Intent intent = new Intent(this, UcActivity.class);
        startActivity(intent);
    }
}