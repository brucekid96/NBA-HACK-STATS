package com.crackbasketballstats.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.crackbasketballstats.data.match.Match;
import com.crackbasketballstats.data.match.MatchDao;
import com.crackbasketballstats.data.team.Team;
import com.crackbasketballstats.data.team.TeamDao;
import com.crackbasketballstats.utils.Converters;


@TypeConverters({Converters.class})
@Database(entities = {Match.class, Team.class}, version = 1)
public abstract class MainDatabase extends RoomDatabase {

  private static final String TAG = MainDatabase.class.getSimpleName();
  private static final String DATABASE_NAME = "crackbasketballstats.db";




  private static volatile MainDatabase INSTANCE;

  public static MainDatabase getDatabase(final Context context) {
    if (INSTANCE == null) {
      synchronized (MainDatabase.class) {
        if (INSTANCE == null) {
          // Create database here
          INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
              MainDatabase.class, MainDatabase.DATABASE_NAME)

              .build();
        }
      }
    }


    return INSTANCE;

  }

  public abstract TeamDao teamDao();
  public abstract MatchDao matchDao();

}
