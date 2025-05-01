package com.therefactorproject.showscheduler;

import com.therefactorproject.show.Show;

import java.util.List;

public class ShowScheduler {
    private List<Show> shows;

    public ShowScheduler(List<Show> shows) {
        this.shows = shows;
    }

    public double calculateTotalDuration() {
        double totalDuration = 0;

        for (Show show : shows) {
            totalDuration += calculateShowDuration(show);
        }

        return totalDuration;
    }

    public double getShowDurationByName(String name) {
        Show show = shows.stream()
            .filter(s -> s.name.equals(name))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Show isn't scheduled"));

        return calculateShowDuration(show);
    }

    private double calculateShowDuration(Show show) {
        double showDuration;

        if ("clown".equals(show.type)) {
            showDuration = show.jokes != null ? show.jokes.size() * 5 : 0;
        } else if ("tightrope".equals(show.type)) {
            showDuration = (show.ropeLength != null ? show.ropeLength / 2 : 0) 
                         + (Boolean.TRUE.equals(show.isBlindfolded) ? 5 : 0);
        } else if ("trapeze".equals(show.type)) {
            showDuration = show.performers != null ? show.performers * 6 : 0;
        } else {
            showDuration = 0;
        }

        return showDuration;
    }
}
