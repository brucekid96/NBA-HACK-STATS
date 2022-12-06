package com.crackbasketballstats.data.team;

import android.content.Context;

import com.crackbasketballstats.data.MainDatabase;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;

public class TeamRepository {

  private MainDatabase db;

  public TeamRepository(Context context) {
    db = MainDatabase.getDatabase(context);

  }


  public Observable<List<Team>> getTeams() {
    return db.teamDao().getTeams();
  }

  public Maybe<Team> getTeam(String teamId) {
    return db.teamDao().getTeam(teamId);
  }


  public Completable insert(Team team) {
    return db.teamDao().insert(team);
       // .andThen(AmplifyAPI.addTeam(team));
  }

  public Completable delete(Team team)  {
    return db.teamDao().delete(team);
  }

  public Completable update(Team team)  {
    return db.teamDao().update(team);
  }

  //public Completable syncTeams() {
   /* return AmplifyAPI.getTeams()
        .flatMapCompletable(db.teamDao()::bulkInsert);*/
  }



  ;

