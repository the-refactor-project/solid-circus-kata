package com.therefactorproject.showscheduler;

import com.therefactorproject.show.Show;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShowSchedulerTest {

    private final Show blindWonderShow = createTightropeShow("The Blind Wonder", 20.0, true);
    private final Show funnyJoeShow = createClownShow("Funny Joe", List.of("joke about Chuck Norris 1", "joke about Chuck Norris 2"));
    private final Show dingoShow = createClownShow("Dingo", List.of("JS developers joke", "backend developers joke", "senior developers joke"));
    private final Show daredevilWalkerShow = createTightropeShow("The Daredevil Walker", 20.0, false);
    private final Show flyingStarsShow = createTrapezeShow("The Flying Stars", 2);
    private final Show threeAmigosShow = createTrapezeShow("The Three Amigos", 3);

    @Test
    void calculatesTotalDurationForClownShow() {
        ShowScheduler scheduler = new ShowScheduler(List.of(dingoShow));

        double totalDuration = scheduler.calculateTotalDuration();

        assertEquals(15, totalDuration);
    }

    @Test
    void calculatesTotalDurationForTightropeShowWithoutBlindfold() {
        ShowScheduler scheduler = new ShowScheduler(List.of(daredevilWalkerShow));

        double totalDuration = scheduler.calculateTotalDuration();

        assertEquals(10, totalDuration);
    }

    @Test
    void calculatesTotalDurationForTightropeShowWithBlindfold() {
        ShowScheduler scheduler = new ShowScheduler(List.of(blindWonderShow));

        double totalDuration = scheduler.calculateTotalDuration();

        assertEquals(15, totalDuration);
    }

    @Test
    void calculatesTotalDurationForTrapezeShow() {
        ShowScheduler scheduler = new ShowScheduler(List.of(threeAmigosShow));

        double totalDuration = scheduler.calculateTotalDuration();

        assertEquals(18, totalDuration);
    }

    @Test
    void calculatesTotalDurationForMultipleShows() {
        ShowScheduler scheduler = new ShowScheduler(List.of(funnyJoeShow, blindWonderShow, flyingStarsShow));

        double totalDuration = scheduler.calculateTotalDuration();

        assertEquals(37, totalDuration);
    }

    @Test
    void calculatesDurationForExistentShowByName() {
        ShowScheduler scheduler = new ShowScheduler(List.of(funnyJoeShow, blindWonderShow, flyingStarsShow));

        double duration = scheduler.getShowDurationByName("Funny Joe");

        assertEquals(10, duration);
    }

    @Test
    void throwsWhenCalculatingDurationForNonExistentShowByName() {
        ShowScheduler scheduler = new ShowScheduler(List.of(funnyJoeShow, blindWonderShow, flyingStarsShow));

        assertThrows(IllegalArgumentException.class, () -> scheduler.getShowDurationByName("The Great FireEater"));
    }

    private Show createClownShow(String name, List<String> jokes) {
        Show show = new Show(name, "clown");
        show.jokes = jokes;
        return show;
    }

    private Show createTightropeShow(String name, double ropeLength, boolean isBlindfolded) {
        Show show = new Show(name, "tightrope");
        show.ropeLength = ropeLength;
        show.isBlindfolded = isBlindfolded;
        return show;
    }

    private Show createTrapezeShow(String name, int performers) {
        Show show = new Show(name, "trapeze");
        show.performers = performers;
        return show;
    }
}
