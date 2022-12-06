package com.crackbasketballstats.data.match;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.crackbasketballstats.data.team.Team;


@Entity(tableName ="matchi")
public class Match implements Parcelable {
  public static final String CrackBasketballStats_EXTRA = "crack_code";

  @NonNull
  @PrimaryKey
  @ColumnInfo(name = "id")
  private String matchid;

  @NonNull
  @ColumnInfo(name = "homeTeamId")
  private String homeTeamId;
  @NonNull
  @ColumnInfo(name = "awayTeamId")
  private String awayTeamId;
  @NonNull
  @ColumnInfo(name = "winTeamId")
  private String winTeamId;
  @NonNull
  @ColumnInfo(name = "assistId")
  private String assistId;
  @NonNull
  @ColumnInfo(name = "twoPointsId")
  private String twoPointsId;
  @NonNull
  @ColumnInfo(name = "threePointsId")
  private String threePointsId;
  @NonNull
  @ColumnInfo(name = "reboundTeamId")
  private String reboundTeamId;
  @NonNull
  @ColumnInfo(name = "fauteTeamId")
  private String fauteTeamId;

  public Match(String matchid, String homeTeamId, String awayTeamId, String winTeamId, String assistId, String twoPointsId, String threePointsId, String reboundTeamId, String fauteTeamId) {
    this.matchid = matchid;
    this.homeTeamId = homeTeamId;
    this.awayTeamId = awayTeamId;
    this.winTeamId = winTeamId;
    this.assistId = assistId;
    this.twoPointsId = twoPointsId;
    this.threePointsId = threePointsId;
    this.reboundTeamId = reboundTeamId;
    this.fauteTeamId = fauteTeamId;
  }

  public String getMatchid() {
    return matchid;
  }

  public void setMatchid(String matchid) {
    this.matchid = matchid;
  }

  @NonNull
  public String getHomeTeamId() {
    return homeTeamId;
  }

  public void setHomeTeamId(String homeTeamId) {
    this.homeTeamId = homeTeamId;
  }
  @NonNull
  public String getAwayTeamId() {
    return awayTeamId;
  }

  public void setAwayTeamId(String awayTeamId) {
    this.awayTeamId = awayTeamId;
  }
  @NonNull
  public String getWinTeamId() {
    return winTeamId;
  }

  public void setWinTeamId(String winTeamId) {
    this.winTeamId = winTeamId;
  }
  @NonNull
  public String getAssistId() {
    return assistId;
  }

  public void setAssistId(String assistId) {
    this.assistId = assistId;
  }
  @NonNull
  public String getTwoPointsId() {
    return twoPointsId;
  }

  public void setTwoPointsId(String twoPointsId) {
    this.twoPointsId = twoPointsId;
  }
  @NonNull
  public String getThreePointsId() {
    return threePointsId;
  }

  public void setThreePointsId(String threePointsId) {
    this.threePointsId = threePointsId;
  }
  @NonNull
  public String getReboundTeamId() {
    return reboundTeamId;
  }

  public void setReboundTeamId(String reboundTeamId) {
    this.reboundTeamId = reboundTeamId;
  }
  @NonNull
  public String getFauteTeamId() {
    return fauteTeamId;
  }

  public void setFauteTeamId(String fauteTeamId) {
    this.fauteTeamId = fauteTeamId;
  }

  @Override
  public String toString() {
    return "Match{" +
        "matchid='" + matchid + '\'' +
        ", homeTeamId='" + homeTeamId + '\'' +
        ", awayTeamId='" + awayTeamId + '\'' +
        ", winTeamId='" + winTeamId + '\'' +
        ", assistId='" + assistId + '\'' +
        ", twoPointsId='" + twoPointsId + '\'' +
        ", threePointsId='" + threePointsId + '\'' +
        ", reboundTeamId='" + reboundTeamId + '\'' +
        ", fauteTeamId='" + fauteTeamId + '\'' +
        '}';
  }

  // PARCELABLE IMPLEMENTATION METHODS
  public Match(Parcel in) {
    this.matchid = in.readString();
    this.homeTeamId = in.readString();
    this.awayTeamId = in.readString();
    this.winTeamId = in.readString();
    this.assistId = in.readString();
    this.twoPointsId = in.readString();
    this.threePointsId = in.readString();
    this.reboundTeamId = in.readString();
    this.fauteTeamId = in.readString();

  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.matchid);
    dest.writeString(this.homeTeamId);
    dest.writeString(this.awayTeamId);
    dest.writeString(this.winTeamId);
    dest.writeString(this.assistId);
    dest.writeString(this.twoPointsId);
    dest.writeString(this.threePointsId);
    dest.writeString(this.reboundTeamId);
    dest.writeString(this.fauteTeamId);
  }

  public static final Parcelable.Creator<Match> CREATOR =
      new Parcelable.Creator<Match>() {
        @Override
        public Match createFromParcel(Parcel source) {
          return new Match(source);
        }

        @Override
        public Match[] newArray(int size) {
          return new Match[size];
        }
      };




}
