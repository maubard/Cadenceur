package com.marion.cadenceur;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import com.marion.cadenceur.model.Area;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testCreateArea() {
        Area area = new Area();
        area.addLine(1.750f, 49.90f);
        area.addLine(2.420f, 30.00f);
        area.addLine(3.620f, 45.50f);
        Float distance = area.calculateDistance(0f);
        Log.d("DISTANCE", "hello " + distance);
    }
}