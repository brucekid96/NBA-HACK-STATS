package com.crackbasketballstats.data.team;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "team")
public class Team implements Parcelable  {
  public static final String CrackBasketballStats_EXTRA = "crack_code";

  @NonNull
  @PrimaryKey
  @ColumnInfo(name = "id")
  private String id;
  @NonNull
  @ColumnInfo(name = "name")
  private String name;
  @NonNull
  @ColumnInfo(name = "conference")
  private String conference;

  public Team(String id, String name, String conference) {
    this.id = id;
    this.name = name;
    this.conference = conference;
  }
  @NonNull
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @NonNull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @NonNull
  public String getConference() {
    return conference;
  }

  public void setConference(String conference) {
    this.conference = conference;
  }

  public String toString() {
    return Team.class.getSimpleName()
        + "["
        + "mId="
        + id.toString()
        + ","
        +"mName="
        + name
        + ","
        +"mConference="
        + conference

        + "]";
  }

  // PARCELABLE IMPLEMENTATION METHODS

  public Team(Parcel in) {
    this.id = in.readString();
    this.name = in.readString();
    this.conference = in.readString();

  }



  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.id);
    dest.writeString(this.name);
    dest.writeString(this.conference);
  }

  public static final Parcelable.Creator<Team> CREATOR =
      new Parcelable.Creator<Team>() {
        @Override
        public Team createFromParcel(Parcel source) {
          return new Team(source);
        }

        @Override
        public Team[] newArray(int size) {
          return new Team[size];
        }
      };


}
