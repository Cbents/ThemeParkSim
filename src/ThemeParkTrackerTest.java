import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ThemeParkTrackerTest {

    @org.junit.jupiter.api.Test
    void addRide() {
        ThemeParkTracker tracker = new ThemeParkTracker();

        Ride ride = new Ride("Roller Coaster", 30, 9, "open");
        Ride ride2 = new Ride("Hurricane", 45, 10, "closed");
        tracker.addRide(ride);
        tracker.addRide(ride2);

        assertEquals(ride, tracker.getRide(0));
        assertEquals(ride2, tracker.getRide((1)));

    }

    @org.junit.jupiter.api.Test
    void getRide() {
        ThemeParkTracker tracker = new ThemeParkTracker();

        Ride ride1 = new Ride("Ferris Wheel", 10, 6, "open");
        Ride ride2 = new Ride("Haunted House", 20, 7, "closed");

        tracker.addRide(ride1);
        tracker.addRide(ride2);

        assertEquals(ride1, tracker.getRide(0));
        assertEquals(ride2, tracker.getRide(1));
    }

    @org.junit.jupiter.api.Test
    void removeClosedRides() {
        ThemeParkTracker tracker = new ThemeParkTracker();

        Ride ride1 = new Ride("Carousel", 5, 5, "open");
        Ride ride2 = new Ride("Drop Tower", 25, 2, "closed");
        Ride ride3 = new Ride("Bumper Cars", 15, 6, "open");

        tracker.addRide(ride1);
        tracker.addRide(ride2);
        tracker.addRide(ride3);

        tracker.removeClosedRides();

        assertEquals(2, tracker.getRide(0) != null && tracker.getRide(1) != null ? 2 : 0);
        assertEquals("Carousel", tracker.getRide(0).getName());
        assertEquals("Bumper Cars", tracker.getRide(1).getName());
    }

    @org.junit.jupiter.api.Test
    void removeRide() {

        ThemeParkTracker tracker = new ThemeParkTracker();

        Ride ride1 = new Ride("Log Flume", 20, 8, "open");
        Ride ride2 = new Ride("Tea Cups", 8, 10, "open");

        tracker.addRide(ride1);
        tracker.addRide(ride2);

        tracker.removeRide(0);

        assertEquals("Tea Cups", tracker.getRide(0).getName());
    }

    @org.junit.jupiter.api.Test
    void sortByWaitTime() {
        ThemeParkTracker tracker = new ThemeParkTracker();

        Ride ride1 = new Ride("Ride A", 40, 10, "open");
        Ride ride2 = new Ride("Ride B", 10, 6, "open");
        Ride ride3 = new Ride("Ride C", 25, 8, "open");

        tracker.addRide(ride1);
        tracker.addRide(ride2);
        tracker.addRide(ride3);

        tracker.sortByWaitTime();

        assertEquals("Ride B", tracker.getRide(0).getName());
        assertEquals("Ride C", tracker.getRide(1).getName());
        assertEquals("Ride A", tracker.getRide(2).getName());
    }

    @org.junit.jupiter.api.Test
    void findRideStatus() {
        ThemeParkTracker tracker = new ThemeParkTracker();

        Ride ride = new Ride("Pirate Ship", 12, 9, "closed");

        tracker.addRide(ride);

        assertEquals("closed", tracker.findRideStatus("Pirate Ship"));
        assertEquals("Ride not found", tracker.findRideStatus("Water Slide"));
    }
}