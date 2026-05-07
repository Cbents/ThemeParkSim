import java.util.ArrayList;

public class ThemeParkTracker {

    private ArrayList<Ride> rides;

    public ThemeParkTracker() {
        rides = new ArrayList<>();
    }

    public void addRide(Ride ride) {
        rides.add(ride);
    }

    public Ride getRide(int index) {
        if (index > rides.size()) {
            return null;
        }

        return rides.get(index);
    }

    public void removeClosedRides() {
        for (int i = 0; i < rides.size(); i++) {
            if (rides.get(i).getStatus().equals("closed")) {
                rides.remove(i);
                i--;
            }
        }
    }

    public void printRide(String name) {
        for (Ride ride : rides) {
            if (ride.getName().equals(name)) {
                System.out.println(ride);
            }
        }
    }

    public void removeRide(int index) {
        if (index >= 0 && index <= rides.size()) {
            rides.remove(index);
        }
    }

    public void printAllRides() {
        for (int i = 0; i < rides.size(); i++) {
            System.out.println(rides.get(i));
        }
    }

    public void sortByWaitTime() {

        for (int i = 0; i < rides.size(); i++) {

            for (int j = i + 1; j < rides.size(); j++) {

                if (rides.get(i).getWaitTime() > rides.get(j).getWaitTime()) {

                    Ride temp = rides.get(i);

                    rides.set(i,rides.get(j));

                    rides.set(j, temp);
                }
            }
        }
    }

    public String findRideStatus(String rideName) {
        if (rides.isEmpty()){
            return "No rides in tracker";
        }
        for (Ride ride : rides) {

            if (ride.getName().equals(rideName)) {
                return ride.getStatus();
            }
        }
        return "Ride not found";


    }
}