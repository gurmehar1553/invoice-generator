package invoiceService;

public class InvoiceGenerator {

    private static final double COST_PER_KILOMETER = 10.0;
    private static final int COST_PER_MINUTE = 1;
    private static final double MIN_FARE = 5.0;

    public double findTotalFare(double dis, int time) {
        double fare= dis*COST_PER_KILOMETER + time*COST_PER_MINUTE;
        return Math.max(fare, MIN_FARE);
    }

    public double findTotalFare(Ride[] rides) {
        double fare = 0;
        for (Ride ride:rides){
            fare += findTotalFare(ride.dist,ride.time);
        }
        return fare;
    }
}
