package com.tw.dir.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

public class JsonParserTest {
    private JsonParser parseDirections;
    private Leg leg;
    private HashSet<StepOfPath> stepOfPaths;

    @Before
    public void setUp() throws Exception {
        JsonReader jsonReader = new JsonReader();
        jsonReader.read("/Users/kvikas/googleDirection/data/test.json");
        parseDirections = jsonReader.parseJson();
        StepOfPath step = new StepOfPath(new Distance("70 m", 70), new Duration("1 min", 55), new EndLocation(1.0, 2.0), "take right", new StartLocation(1.0, 2.0), "WALKING");
        stepOfPaths = new HashSet<StepOfPath>();
        stepOfPaths.add(step);

        leg = new Leg(new Distance("7.4 km", 7355), new Duration("1 hour 33 mins", 5569), "xyz", new EndLocation(1.0, 2.0), "abc", new StartLocation(1.0, 2.0), stepOfPaths);
    }

    @Test
    public void shouldReturnAllRoutes() throws Exception {
        Assert.assertEquals(parseDirections.getAllRoute().size(), 1);
    }

    @Test
    public void shouldReturnLegs() throws Exception {
        Assert.assertEquals(parseDirections.getLegsBoundOfGivenIndex(0).size(), 1);
    }

    @Test
    public void shouldReturnAParticularLeg() throws Exception {
        Assert.assertEquals(parseDirections.getParticularLegOfGivenIndexOfRoute(0, 0), leg);

    }

    @Test
    public void shouldReturnAllLeg() throws Exception {
        ArrayList<Leg> legs = new ArrayList<Leg>();
        legs.add(leg);
        Assert.assertEquals(parseDirections.getAllLegsARoute(0), legs);

    }

    @Test
    public void shouldReturnAllStepOfALegOfGivenRouter() throws Exception {
        Assert.assertEquals(parseDirections.getAllStep(0,0), stepOfPaths);
    }
}