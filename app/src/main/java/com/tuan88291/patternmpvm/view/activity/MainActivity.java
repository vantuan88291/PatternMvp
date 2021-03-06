package com.tuan88291.patternmpvm.view.activity;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.tuan88291.patternmpvm.BaseActivity;
import com.tuan88291.patternmpvm.R;
import com.tuan88291.patternmpvm.data.local.model.Data;
import com.tuan88291.patternmpvm.view.fragment.about.About;
import com.tuan88291.patternmpvm.view.fragment.homefragment.HomeFragment;
import com.tuan88291.patternmpvm.databinding.ActivityMainBinding;

import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.lifecycle.ViewModelProviders;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ActivityMainBinding binding;
    private Data item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.executePendingBindings();
        setSupportActionBar(binding.appBar.toolbar);
        item = ViewModelProviders.of(this).get(Data.class);
        binding.appBar.fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, binding.drawerLayout, binding.appBar.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        binding.navView.setNavigationItemSelectedListener(this);
        addFragment(new HomeFragment());

    }

    public void setItem(String it){
        item.setExample(it);
    }
    public String getItem(){
        return item.getExample();
    }
    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            addFragment(new HomeFragment());
        } else if (id == R.id.nav_gallery) {
            addFragment(new About());

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
