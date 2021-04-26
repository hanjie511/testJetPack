package com.example.testjetpack;

import java.util.Objects;

public class Road {
    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getRoadCode() {
        return roadCode;
    }

    public void setRoadCode(String roadCode) {
        this.roadCode = roadCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return Objects.equals(roadName, road.roadName) &&
                Objects.equals(roadCode, road.roadCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roadName, roadCode);
    }

    private String roadName;
    private String roadCode;
}
