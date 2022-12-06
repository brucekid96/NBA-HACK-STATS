package com.crackbasketballstats;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

public class AddMatch extends AppCompatActivity {

  private Spinner homeSpinner;
  private Spinner awaySpinner;
  private Spinner winTeamSpinner;
  private Spinner assistWinSpinner;
  private Spinner twoPointsWinSpinner;
  private Spinner threePointWinSpinner;
  private Spinner reboundsWinSpinner;
  private Spinner fauteWinSpinner;
  private Button validate;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
//        loadLocale();
    setContentView(R.layout.add_match);


    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    homeSpinner = findViewById(R.id.homeTeamSpinner);
    awaySpinner = findViewById(R.id.awayTeamSpinner);
    winTeamSpinner = findViewById(R.id.winTeamSpinner);
    assistWinSpinner = findViewById(R.id.assistTeamSpinner);
    twoPointsWinSpinner = findViewById(R.id.twoPointsTeamSpinner);
    threePointWinSpinner = findViewById(R.id.threePointsTeamSpinner);
    reboundsWinSpinner  = findViewById(R.id.rebTeamSpinner);
    fauteWinSpinner = findViewById(R.id.fauteTeamSpinner);

    validate = findViewById(R.id.match_validate);






  }
}
