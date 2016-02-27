package com.marion.whitemadder.model;

/**
 * Copyright (c) 28/01/16 marion
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR
 * ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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

    public void setDistance(Float mDistance) {
        this.mDistance = mDistance;
    }

    public void setAverage(Float mAverage) {
        this.mAverage = mAverage;
    }

    @Override
    public int compareTo(Line line) {
        if (this.getDistance() == null || line.getDistance() == null)
            return 0;
        return this.getDistance().compareTo(line.getDistance());
    }
}
