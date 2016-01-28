package com.marion.cadenceur.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marion on 28/01/16.
 */
public class Area {

    private List<Line> mLines;

    public Area() {
        this.mLines = new ArrayList<Line>();
    }

    public void addLine(Float distance, Float moyenne) {
        Line line = new Line(mLines.size(), distance, moyenne);
        mLines.add(line);
    }

    public Float calculateDistance(Float time) {
        Float distance = 0f;
        Float tmpTime = 0f;
        if (mLines.size() == 0) return distance;
        distance = (mLines.get(0).getMoyenne() / 3600f) * time;

        for (int i=0 ; i < mLines.size() ; i++) {
            Line line = mLines.get(i);
            if (distance >= line.getDistance()) {
                tmpTime = tmpTime + line.getDistance() / (line.getMoyenne() / 3600.0f);
                if (i < mLines.size()-1)
                    distance = line.getDistance() + (mLines.get(i+1).getMoyenne() / 3600f) * (time - tmpTime);
            }
        }
        return distance;

    }


}
