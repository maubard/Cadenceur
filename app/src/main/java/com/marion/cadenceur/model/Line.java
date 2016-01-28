package com.marion.cadenceur.model;

/**
 * Created by marion on 28/01/16.
 */
public class Line implements Comparable<Line> {

    private Float mDistance;
    private Float mMoyenne;

    public Line(Float distance, Float moyenne) {
        mDistance = distance;
        mMoyenne = moyenne;
    }

    public Float getMoyenne() {
        return mMoyenne;
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
