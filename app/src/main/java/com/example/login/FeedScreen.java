package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.EventLogTags;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class FeedScreen extends AppCompatActivity {

    List<ListElement> elements;
    DrawerLayout drawerLayout;

    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_screen);
        /*drawerLayout.findViewById(R.id.drawer_layout);
        navigationView.findViewById((R.id.nav_view));
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.home)
                {
                    Toast.makeText(FeedScreen.this,"Home",Toast.LENGTH_SHORT).show();
                }
                if(item.getItemId() == R.id.cuenta)
                {
                    Toast.makeText(FeedScreen.this,"cuenta",Toast.LENGTH_SHORT).show();
                }
                if(item.getItemId() == R.id.crear)
                {
                    Toast.makeText(FeedScreen.this,"crear",Toast.LENGTH_SHORT).show();
                }
                if(item.getItemId() == R.id.reportes)
                {
                    Toast.makeText(FeedScreen.this,"reportes",Toast.LENGTH_SHORT).show();
                }
                if(item.getItemId() == R.id.salir)
                {
                    Toast.makeText(FeedScreen.this,"salir",Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });*/
        init();
    }

    public void init()
    {
        elements = new ArrayList<>();
        elements.add(new ListElement("Ramiro","Perro","Encontrado","31/05/2023","78399"));
        elements.add(new ListElement("Ramiro","Perro","Encontrado","31/05/2023","78399"));
        elements.add(new ListElement("Ramiro","Perro","Encontrado","31/05/2023","78399"));
        elements.add(new ListElement("Ramiro","Perro","Encontrado","31/05/2023","78399"));
        elements.add(new ListElement("Ramiro","Perro","Encontrado","31/05/2023","78399"));
        elements.add(new ListElement("Ramiro","Perro","Encontrado","31/05/2023","78399"));
        elements.add(new ListElement("Ramiro","Perro","Encontrado","31/05/2023","78399"));

        ListAdapter listAdapter = new ListAdapter(elements, this, new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ListElement item) {
                moveToDescription(item);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

    public void moveToDescription(ListElement item)
    {
        Intent intent = new Intent(this, DescriptionReport.class);
        intent.putExtra("ListElement",item);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }
}