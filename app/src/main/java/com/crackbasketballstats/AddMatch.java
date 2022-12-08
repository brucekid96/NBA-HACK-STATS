package com.crackbasketballstats;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.crackbasketballstats.data.match.Match;
import com.crackbasketballstats.data.match.MatchRepository;
import com.crackbasketballstats.data.team.Team;
import com.crackbasketballstats.data.team.TeamRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class AddMatch extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

  private Spinner homeSpinner;
  private Spinner awaySpinner;
  private Spinner winTeamSpinner;
  private Spinner assistWinSpinner;
  private Spinner twoPointsWinSpinner;
  private Spinner threePointWinSpinner;
  private Spinner reboundsWinSpinner;
  private Spinner fauteWinSpinner;
  private Button validate;
  private ArrayAdapter<String> mAdapter;

  private List<Team> mListTeam ;
  List<String> mTeams;

  private TeamRepository mTeamRepository;
  private MatchRepository mMatchRepository;
  private CompositeDisposable mDisposable = new CompositeDisposable();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
//        loadLocale();
    setContentView(R.layout.add_match);


    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    mTeamRepository = new TeamRepository(getApplicationContext());

    mMatchRepository = new MatchRepository(getApplicationContext());

    mTeamRepository.getTeams()
        .flattenAsObservable(it -> it)
        .map(Team::getName)
        .toList()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(this::loadTeams)
    ;


    homeSpinner = findViewById(R.id.homeTeamSpinner);

    awaySpinner = findViewById(R.id.awayTeamSpinner);
    winTeamSpinner = findViewById(R.id.winTeamSpinner);
    assistWinSpinner = findViewById(R.id.assistTeamSpinner);
    twoPointsWinSpinner = findViewById(R.id.twoPointsTeamSpinner);
    threePointWinSpinner = findViewById(R.id.threePointsTeamSpinner);
    reboundsWinSpinner = findViewById(R.id.rebTeamSpinner);
    fauteWinSpinner = findViewById(R.id.fauteTeamSpinner);

    mTeams = new ArrayList<>();


    // on below line we are initializing adapter for our spinner
    mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
    // on below line we are setting drop down view resource for our adapter.
    mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


    homeSpinner.setAdapter(mAdapter);
    awaySpinner.setAdapter(mAdapter);
    winTeamSpinner.setAdapter(mAdapter);
    assistWinSpinner.setAdapter(mAdapter);
    twoPointsWinSpinner.setAdapter(mAdapter);
    threePointWinSpinner.setAdapter(mAdapter);
    reboundsWinSpinner.setAdapter(mAdapter);
    fauteWinSpinner.setAdapter(mAdapter);


    homeSpinner.setOnItemSelectedListener(this);
    awaySpinner.setOnItemSelectedListener(this);
    winTeamSpinner.setOnItemSelectedListener(this);
    assistWinSpinner.setOnItemSelectedListener(this);
    twoPointsWinSpinner.setOnItemSelectedListener(this);
    threePointWinSpinner.setOnItemSelectedListener(this);
    reboundsWinSpinner.setOnItemSelectedListener(this);
    fauteWinSpinner.setOnItemSelectedListener(this);


    validate = findViewById(R.id.match_validate);

    validate.setOnClickListener(view -> {


            Match match = new Match(
                UUID.randomUUID().toString(),
                homeSpinner.getSelectedItem().toString(),
                awaySpinner.getSelectedItem().toString(),
                winTeamSpinner.getSelectedItem().toString(),
                assistWinSpinner.getSelectedItem().toString(),
                twoPointsWinSpinner.getSelectedItem().toString(),
                threePointWinSpinner.getSelectedItem().toString(),
                reboundsWinSpinner.getSelectedItem().toString(),
                fauteWinSpinner.getSelectedItem().toString()
            );

            mMatchRepository.insert(match)
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                }, e -> {
                });

            Log.d(AddMatch.class.getSimpleName(), "Added match: " + match.toString());

            Intent intent1 = new Intent(AddMatch.this, MainActivity.class);
            intent1.putExtra(Team.CrackBasketballStats_EXTRA, match);
            startActivity(intent1);

        }
    );
  }

  private void loadTeams(List<String> teams) {
    mTeams = teams;
    mAdapter.addAll(mTeams);
  }

  @Override
  public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    // on below line we are displaying toast message for selected item
    Toast.makeText(AddMatch.this, "" +  "cool", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onNothingSelected(AdapterView<?> adapterView) {

  }
}
