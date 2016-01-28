package com.marion.cadenceur.model;

/**
 * Created by marion on 28/01/16.
 */
public class Line {

    private Float mDistance;
    private Float mMoyenne;
    private Integer mIndex;

    public Line(Integer index, Float distance, Float moyenne) {
        mIndex = index;
        mDistance = distance;
        mMoyenne = moyenne;
    }

    public Float getMoyenne() {
        return mMoyenne;
    }

    public Float getDistance() {
        return mDistance;
    }
}
