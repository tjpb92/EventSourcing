package eventsourcing;

import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.7
 */
public class DistributeurCounterTest {

    private static final UUID AGGREGATE_UUID = UUID.randomUUID();
    private static final String NAME = "totolito";
    private static final String EMAIL = NAME + "@mail.com";
    private static final Distributor DISTRIBUTOR = new Distributor(NAME, EMAIL);

    public DistributeurCounterTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getCounter method, of class DistributeurCounter.
     */
    @Test
    public void testCounterIncremented() {
        DistributeurCounter instance = new DistributeurCounter();
        long originalCounter = instance.getCounters(AGGREGATE_UUID);

        DistributorRegistered distributorRegistered = new DistributorRegistered(AGGREGATE_UUID, new DistributorAbstract(DISTRIBUTOR));
        instance.handle(distributorRegistered);

        long expResult = originalCounter + 1;
        long result = instance.getCounters(AGGREGATE_UUID);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCounter method, of class DistributeurCounter.
     */
    @Test
    public void testCounterDecremented() {
        DistributeurCounter instance = new DistributeurCounter();

        long originalCounter = instance.getCounters(AGGREGATE_UUID);
//        System.out.println("originalCounter:"+originalCounter+", UUID:"+TSTUUID);

        DistributorUnregistered distributorUnregistered = new DistributorUnregistered(AGGREGATE_UUID, new DistributorAbstract(DISTRIBUTOR));
        instance.handle(distributorUnregistered);

        long expResult = originalCounter - 1;
        long result = instance.getCounters(AGGREGATE_UUID);
        assertEquals(expResult, result);
    }

}
