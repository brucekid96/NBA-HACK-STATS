package com.crackbasketballstats.data.match;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.crackbasketballstats.data.team.Team;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
@Dao
public interface MatchDao {

  @Insert
  Completable insert(Match match);

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  Completable bulkInsert(List<Match> matchs);

  @Delete
  Completable delete(Match match);
  @Update
  Completable update(Match match);

  @Query("SELECT * from matchi ")
  Observable<List<Match>> getMatchs();


  @Query("SELECT * from  matchi where id = :matchId ")
  Maybe<Match> getMatch(String matchId);
}
