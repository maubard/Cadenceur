package com.marion.whitemadder.model;

/**
 * Created by marion on 28/01/16.
 */
public class Line implements Comparable<Line> {

    private Float mDistance;
    private Float mAverage;

    public Line(Float distance, Float average) {
        mDistance = distance;
        mAverage = average;
    }

    public Float getAverage() {
        return mAverage;
    }

    public Float getDistance() {
        return mDistance;
    }

    @Override
    public int compareTo(Line line) {
        if (this.getDistance() == null || line.getDistance() == null)
            return 0;
        return this.getDistance().compareTo(line.getDistance());
    }
}
