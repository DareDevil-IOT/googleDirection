package com.tw.dir.main;

import com.tw.dir.directionApi.DirectionRetriever;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://maps.googleapis.com/maps/api/directions/json?origin=koramangla+3rd+block+bangalore&destination=thoughtworks+bangalore+india&departure_time=1541202457&traffic_model=best_guess&language=english&mode=walking&region=ES&key=API_KEY";
        DirectionRetriever retrieveDirection = new DirectionRetriever();
        retrieveDirection.downloadUrl(url);
    }
}
