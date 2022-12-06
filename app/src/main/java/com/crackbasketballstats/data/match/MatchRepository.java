package com.crackbasketballstats.data.match;

import android.content.Context;

import com.crackbasketballstats.data.MainDatabase;
import com.crackbasketballstats.data.team.Team;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;

public class MatchRepository {

  private MainDatabase db;

  public MatchRepository(Context context) {
    db = MainDatabase.getDatabase(context);

  }


  public Observable<List<Match>> getMatchs() {
    return db.matchDao().getMatchs();
  }

  public Maybe<Match> getMatch(String matchId) {
    return db.matchDao().getMatch(matchId);
  }


  public Completable insert(Match match) {
    return db.matchDao().insert(match);
    // .andThen(AmplifyAPI.addMatch(match));
  }

  public Completable delete(Match match)  {
    return db.matchDao().delete(match);
  }

  public Completable update(Match match)  {
    return db.matchDao().update(match);
  }
}
