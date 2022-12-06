package com.crackbasketballstats.data.team;

import android.os.Parcelable;

public class Team  {
  public static final String CrackBasketballStats_EXTRA = "crack_code";

  private String id;
  private String name;
  private String conference;

  public Team(String id, String name, String conference) {
    this.id = id;
    this.name = name;
    this.conference = conference;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getConference() {
    return conference;
  }

  public void setConference(String conference) {
    this.conference = conference;
  }


}
