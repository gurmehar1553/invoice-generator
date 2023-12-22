package invoiceService;

import java.util.HashMap;

public class InvoiceGenerator {
    private static final double COST_PER_KILOMETER = 10.0;
    private static final int COST_PER_MINUTE = 1;
    private static final double MIN_FARE = 5.0;
    private static HashMap<String, Ride[]> rideRepository;
    public InvoiceGenerator(){
        rideRepository = new HashMap<>();
    }

    public double findTotalFare(double dis, int time) {
        double fare= dis*COST_PER_KILOMETER + time*COST_PER_MINUTE;
        return Math.max(fare, MIN_FARE);
    }

    public InvoiceSummary findTotalFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride:rides){
            totalFare += findTotalFare(ride.dist,ride.time);
        }
        double avgFare = (totalFare)/ rides.length;
        return new InvoiceSummary(rides.length,totalFare, avgFare);
    }

    public void addRide(String userId, Ride[] rides) {
        rideRepository.put(userId,rides);
    }

    public InvoiceSummary findTotalFare(String userId) {
        Ride[] rides = rideRepository.get(userId);
        return this.findTotalFare(rides);
    }
}
