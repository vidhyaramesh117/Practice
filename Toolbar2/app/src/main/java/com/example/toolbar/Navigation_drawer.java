package com.example.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class Navigation_drawer extends AppCompatActivity
{

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    private Fragment fragment;

    private int[] tabicons=
            {
                    R.drawable.chats,
                    R.drawable.status,
                    R.drawable.calls,
                    R.drawable.fav,
                    R.drawable.stared,
                    R.drawable.download
            };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        drawerLayout = findViewById(R.id.nav_drawer);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.tb);
        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.vp);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        setViewpager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        setTabicons();


        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("WHATSAPP");
        }
        toolbar.setSubtitle("");

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.OpenDrawer,R.string.CloseDraw);

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                int id = item.getItemId();
                if(id==R.id.profile)
                {
                    loadFragment(new fragment_profile());
                }
                else if(id==R.id.cloud)
                {
                    Toast.makeText(Navigation_drawer.this, "Cloud stoarge", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Navigation_drawer.this, "Log out", Toast.LENGTH_SHORT).show();
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }



    private void setViewpager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter .addFragment(new chat_Fragment(),"Chats");
        adapter .addFragment(new status_Fragment(),"Status");
        adapter .addFragment(new calls_Fragment(),"Calls");
        adapter .addFragment(new fav_Fragment(),"Favourite");
        adapter .addFragment(new stared_Fragment(),"Stared msges");
        adapter .addFragment(new download_Fragment(),"Download");
        viewPager.setAdapter(adapter);
    }

    private void setTabicons()
    {
        tabLayout.getTabAt(0).setIcon(tabicons[0]);
        tabLayout.getTabAt(1).setIcon(tabicons[1]);
        tabLayout.getTabAt(2).setIcon(tabicons[2]);
        tabLayout.getTabAt(3).setIcon(tabicons[3]);
        tabLayout.getTabAt(4).setIcon(tabicons[4]);
//        tabLayout.getTabAt(5).setIcon(tabicons[5]);
    }


    @Override
    public void onBackPressed()
    {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(Navigation_drawer.this);
            builder.setMessage("Do you want to exit?");
            builder.setTitle("ALERT");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes",(DialogInterface.OnClickListener) (Dialog, which) ->
            {
                System.exit(0);   //used to exit
            });
            builder.setNegativeButton("No",(DialogInterface.OnClickListener)(Dialog, which) ->
            {
                Dialog.cancel();
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }

    private void loadFragment(fragment_profile fragment_profile)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.container,fragment);
        ft.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.opt_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        int itemId = item.getItemId();
        if (itemId==R.id.opt_grp)
        {
            Intent intent = new Intent(getApplicationContext(),activity_new_group.class);
            startActivity(intent);
//            Toast.makeText(this, "Created new group", Toast.LENGTH_SHORT).show();
        }
        else if(itemId==R.id.opt_broad)
        {
            Intent intent = new Intent(getApplicationContext(),activity_new_broadcast.class);
            startActivity(intent);
//            Toast.makeText(this, "Created new broadcast", Toast.LENGTH_SHORT).show();
        }
        else if(itemId==android.R.id.home)
        {
            super.onBackPressed();
        }
        else if(itemId==R.id.opt_sett)
        {
            Intent intent = new Intent(getApplicationContext(),activity_settings.class);
            startActivity(intent);
//            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}