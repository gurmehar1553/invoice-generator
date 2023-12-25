package invoiceService;

public class InvoiceSummary {
    private final int numRides;
    private final double totalFare;
    private final double avgFare;

    public InvoiceSummary(int numRides, double totalFare, double avgFare) {
        this.numRides = numRides;
        this.totalFare = totalFare;
        this.avgFare = avgFare;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return numRides == that.numRides && Double.compare(totalFare, that.totalFare) == 0
                && Double.compare(avgFare, that.avgFare) == 0;
    }

}
