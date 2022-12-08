package com.crackbasketballstats;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.crackbasketballstats.data.team.Team;
import com.crackbasketballstats.data.team.TeamRepository;
import com.google.android.material.textfield.TextInputLayout;

import java.util.UUID;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AddTeam extends AppCompatActivity {
  private TextInputLayout mName;
  private TextInputLayout mConference;
  private Button mValidate;
  private TeamRepository mTeamRepository;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.add_team);

    Toolbar toolbar = findViewById(R.id.add_team_toolbar);
    setSupportActionBar(toolbar);
    mTeamRepository = new TeamRepository(getApplicationContext());

    mName = findViewById(R.id.team_name);

    mConference = findViewById(R.id.conference);

    mValidate = findViewById(R.id.team_validate);

    mValidate.setOnClickListener(view -> {
      if (mName.getEditText().length()!=0 && mConference.getEditText().length()!=0) {
        Team team = new Team(
            UUID.randomUUID().toString(),
            mName.getEditText().getText().toString(),
            mConference.getEditText().getText().toString()
        );
        mTeamRepository.insert(team)
            .subscribeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(() -> {
            }, e -> {
            });

        Log.d(AddTeam.class.getSimpleName(), "Added team: " + team.toString());

        Intent intent1 = new Intent(AddTeam.this, MainActivity.class);
        intent1.putExtra(Team.CrackBasketballStats_EXTRA, team);
        startActivity(intent1);
      }

    });







  }
}
