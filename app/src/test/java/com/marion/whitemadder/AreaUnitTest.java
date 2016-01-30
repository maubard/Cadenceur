package com.marion.whitemadder.;

import com.marion.whitemadder.model.Area;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by marion on 28/01/16.
 */
public class AreaUnitTest {

    @Test
    public void testCalculate() {
        // Create area
        Area area = new Area();
        area.addLine(1.750f, 50.00f);
        area.addLine(2.420f, 30.00f);
        area.addLine(3.620f, 45.50f);

        // Do some calculation tests
        Float distance = area.calculateDistance(0f);
        assertEquals(0f, distance.floatValue(), 0f);

        distance = area.calculateDistance(126.0f);
        assertEquals(1.750f, distance.floatValue(), 0.001f);

        distance = area.calculateDistance(206.4f);
        assertEquals(2.420f, distance.floatValue(), 0.001f);

        distance = area.calculateDistance(210.0f);
        assertEquals(2.466f, distance.floatValue(), 0.001f);

        distance = area.calculateDistance(500.0f);
        assertEquals(6.131f, distance.floatValue(), 0.001f);
    }

    @Test
    public void testSort() {
        // Create area
        Area area = new Area();
        area.addLine(3.00f, 50.00f);
        area.addLine(2.00f, 30.00f);
        area.addLine(5.00f, 45.50f);
        area.sort();

        // Assert sort feature is ok
        assertEquals(2.00f, area.getLineAtIndex(0).getDistance(), 0.001f);
        assertEquals(3.00f, area.getLineAtIndex(1).getDistance(), 0.001f);
        assertEquals(5.00f, area.getLineAtIndex(2).getDistance(), 0.001f);
    }
}
