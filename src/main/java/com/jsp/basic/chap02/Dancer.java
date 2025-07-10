package com.jsp.basic.chap02;

import java.util.List;
import java.util.Objects;

// 댄서 1명의 정보를 가질 객체의 설계도
public class Dancer {

    private String name;
    private String crewName;
    private DanceLevel danceLevel;
    private List<Genre> genres;

    public Dancer(String name, String crewName, DanceLevel danceLevel, List<Genre> genres) {
        this.name = name;
        this.crewName = crewName;
        this.danceLevel = danceLevel;
        this.genres = genres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrewName() {
        return crewName;
    }

    public void setCrewName(String crewName) {
        this.crewName = crewName;
    }

    public DanceLevel getDanceLevel() {
        return danceLevel;
    }

    public void setDanceLevel(DanceLevel danceLevel) {
        this.danceLevel = danceLevel;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Dancer dancer)) return false;
        return Objects.equals(name, dancer.name) && Objects.equals(crewName, dancer.crewName) && danceLevel == dancer.danceLevel && Objects.equals(genres, dancer.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, crewName, danceLevel, genres);
    }

    @Override
    public String toString() {
        return "Dancer{" +
                "name='" + name + '\'' +
                ", crewName='" + crewName + '\'' +
                ", danceLevel=" + danceLevel +
                ", genres=" + genres +
                '}';
    }
}
