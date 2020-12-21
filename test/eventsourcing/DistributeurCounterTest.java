package eventsourcing;

import static eventsourcing.JeuxDEssais.AGGREGATE_UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static eventsourcing.JeuxDEssais.DISTRIBUTOR;

/**
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.10
 */
public class DistributeurCounterTest {

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

        DistributorRegistered distributorRegistered = new DistributorRegistered(AGGREGATE_UUID, 0, new DistributorAbstract(DISTRIBUTOR));
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

        DistributorUnregistered distributorUnregistered = new DistributorUnregistered(AGGREGATE_UUID, 0, new DistributorAbstract(DISTRIBUTOR));
        instance.handle(distributorUnregistered);

        long expResult = originalCounter - 1;
        long result = instance.getCounters(AGGREGATE_UUID);
        assertEquals(expResult, result);
    }

}
