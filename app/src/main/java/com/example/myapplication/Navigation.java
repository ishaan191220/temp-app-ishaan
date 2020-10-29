package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.widget.Toolbar;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class Navigation extends AppCompatActivity {
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;



    // Make sure to be using androidx.appcompat.app.ActionBarDrawerToggle version.
    private ActionBarDrawerToggle drawerToggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // ...From section above...
        setContentView(R.layout.activity_navigation);

        // Set a Toolbar to replace the ActionBar.
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // This will display an Up icon (<-), we will replace it with hamburger later
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Find our drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        // Find our drawer view
        super.onCreate(savedInstanceState);
         nvDrawer = (NavigationView) findViewById(R.id.nvView);
        // Setup drawer view
        setupDrawerContent(nvDrawer);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }





    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass;
        switch(menuItem.getItemId()) {
            case R.id.nav_pracmarks:
                fragmentClass = addpracmarks.class;
                break;
            case R.id.nav_testmarks:
                fragmentClass = addtestmarks.class;
                break;
            case R.id.nav_viewtt:
                fragmentClass = viewtt.class;
                break;

            case R.id.nav_home:
                fragmentClass = home.class;
                break;

            case R.id.nav_logout:
                fragmentClass = logout.class;
                break;
                
                
                
            default:
                fragmentClass = home.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frag, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        mDrawer.closeDrawers();
    }

    // ...
}