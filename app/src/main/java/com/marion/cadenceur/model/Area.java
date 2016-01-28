package com.marion.cadenceur.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by marion on 28/01/16.
 */
public class Area {

    private List<Line> mLines;

    public Area() {
        this.mLines = new ArrayList<Line>();
    }

    /**
     * Get line at given index
     *
     * @param index
     * @return the matching Line object
     */
    public Line getLineAtIndex(int index) {
        return mLines.get(index);
    }

    /**
     * Add a Line to this Area. It is added to the end of the lines list
     *
     * @param distance
     * @param moyenne
     */
    public void addLine(Float distance, Float moyenne) {
        Line line = new Line(distance, moyenne);
        mLines.add(line);
        sort();
    }

    /**
     * According to all lines and given time, calculate the distance
     *
     * @param time
     * @return the calculated distance
     */
    public Float calculateDistance(long time) {
        Float distance = 0f;
        Float tmpTime = 0f;
        if (mLines.size() == 0) return distance;
        distance = (mLines.get(0).getMoyenne() / 3600f) * time;

        for (int i=0 ; i < mLines.size() ; i++) {
            Line line = mLines.get(i);
            Line previousLine = new Line(0f, 0f);
            Line nextLine = null;
            if (i > 0) previousLine = mLines.get(i - 1);
            if (i < mLines.size() - 1) nextLine = mLines.get(i + 1);
            if (distance >= line.getDistance() && nextLine != null) {
                tmpTime = tmpTime + (line.getDistance() - previousLine.getDistance()) / (line.getMoyenne() / 3600.0f);
                distance = line.getDistance() + (nextLine.getMoyenne() / 3600f) * (time - tmpTime);
            }
        }
        return distance;

    }

    /**
     * Sort lines by distance
     */
    public void sort() {
        Collections.sort(mLines);
    }
}
