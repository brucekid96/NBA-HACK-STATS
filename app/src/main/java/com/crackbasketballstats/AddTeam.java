package com.crackbasketballstats;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputLayout;

public class AddTeam extends AppCompatActivity {
  private TextInputLayout mName;
  private TextInputLayout mConference;
  private Button mValidate;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.add_team);

    Toolbar toolbar = findViewById(R.id.add_team_toolbar);
    setSupportActionBar(toolbar);

    mName = findViewById(R.id.team_name);

    mConference = findViewById(R.id.conference);

    mValidate = findViewById(R.id.team_validate);







  }
}
