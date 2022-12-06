package com.crackbasketballstats;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

  private CardView mAddTeam;
  private ImageView mAddTeamIcon;

  private CardView mAddMatch;
  private ImageView mAddMatchIcon;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    DrawerLayout drawer =  findViewById(R.id.drawer_layout);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    mAddTeam=findViewById(R.id.add_team_crd);
    mAddTeam.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, AddTeam.class)));
    mAddTeamIcon=findViewById(R.id.add_team_icon);

    mAddMatch=findViewById(R.id.add_match_crd);
    mAddMatch.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, AddMatch.class)));
    mAddMatchIcon=findViewById(R.id.add_match_icon);



    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView =
        findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);


  }

  @Override
  public void onBackPressed() {
    DrawerLayout drawer = (DrawerLayout)
        findViewById(R.id.drawer_layout);
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  public boolean onNavigationItemSelected(MenuItem item) {
    // Handle navigation view item clicks here.
    Intent intent = null;
    int id = item.getItemId();

    if (id == R.id.nav_home) {
      // Handle the camera action
      Toast.makeText(getApplicationContext(),"home",Toast.LENGTH_LONG).show();

    } else if (id == R.id.nav_home_2points) {
      startActivity(new Intent(MainActivity.this, HomeTeam2points.class));

    } else if (id == R.id.nav_home_3points) {
      startActivity(new Intent(MainActivity.this, HomeTeam3points.class));


    }  else if (id == R.id.nav_home_rebounds) {
      startActivity(new Intent(MainActivity.this, HomeTeamRebounds.class));
    }  else if (id == R.id.nav_home_assists) {
      startActivity(new Intent(MainActivity.this, HomeTeamAssists.class));
    }  else if (id == R.id.nav_home_fautes) {
      startActivity(new Intent( MainActivity.this,HomeTeamFautes.class));
    }
    else if (id == R.id.nav_away_2points) {
      startActivity(new Intent( MainActivity.this,AwayTeam2points.class));
    }  else if (id == R.id.nav_away_3points) {
      startActivity(new Intent( MainActivity.this,AwayTeam3points.class));
    } else if (id == R.id.nav_away_rebounds) {
      startActivity(new Intent( MainActivity.this,AwayTeamRebounds.class));
    }  else if (id == R.id.nav_away_assists) {
      startActivity(new Intent( MainActivity.this,AwayTeamAssists.class));
    }  else if (id == R.id.nav_away_fautes) {
      startActivity(new Intent( MainActivity.this,AwayTeamFautes.class));
    } else if (id == R.id.nav_overall_2points) {
      startActivity(new Intent( MainActivity.this,OverAll2points.class));
    } else if (id == R.id.nav_overall_3points) {
      startActivity(new Intent( MainActivity.this,OverAll3points.class));
    } else if (id == R.id.nav_overall_rebounds) {
      startActivity(new Intent( MainActivity.this,OverAllRebounds.class));
    } else if (id == R.id.nav_overall_assists) {
      startActivity(new Intent( MainActivity.this,OverAllAssists.class));
    } else if (id == R.id.nav_overall_fautes) {
      startActivity(new Intent( MainActivity.this,OverAllfautes.class));
    }
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }
}