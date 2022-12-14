package com.crackbasketballstats.data.team;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

@Dao
public interface TeamDao {

  @Insert
  Completable insert(Team team);

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  Completable bulkInsert(List<Team> teams);

  @Delete
  Completable delete(Team team);
  @Update
  Completable update(Team team);

  @Query("SELECT * from team  order by name asc ")
  Single<List<Team>> getTeams();


  @Query("SELECT * from  team where id = :teamId ")
  Maybe<Team> getTeam(String teamId);
}
