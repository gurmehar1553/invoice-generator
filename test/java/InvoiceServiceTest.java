import invoiceService.InvoiceGenerator;
import invoiceService.Ride;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator = null;
    @Before
    public void setUp() throws Exception{
        invoiceGenerator = new InvoiceGenerator();
    }
    @Test
    public void givenDistanceTime_ShouldReturnTotalFare(){
        double dist = 20.0;
        int time = 10;
        double cost = invoiceGenerator.findTotalFare(dist,time);
        Assert.assertEquals(210.0,cost,0.0);
    }
    @Test
    public void givenDistanceTime_ShouldReturnMinimumFare(){
        double dist = 0.2;
        int time = 2;
        double cost = invoiceGenerator.findTotalFare(dist,time);
        Assert.assertEquals(5,cost,0.0);
    }
    @Test
    public void givenMultipleRides_ShouldReturnTotalFare(){
        Ride[] rides={new Ride(20.0,10), new Ride(0.2,2)};
        double fare = invoiceGenerator.findTotalFare(rides);
        Assert.assertEquals(215,fare,0.0);
    }
}
