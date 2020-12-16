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
 * @version 0.1.5
 */
public class DistributeurCounterTest {
    
    private static final UUID TSTUUID = UUID.randomUUID();
    private static final String TSTNAME = "totolito";
    private static final String TSTEMAIL = TSTNAME + "@mail.com";
    private static final Distributor TSTDISTRIBUTOR = new Distributor(TSTNAME, TSTEMAIL);
    
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
        long originalCounter = instance.getCounters(TSTUUID);
        
        DistributorRegistered distributorRegistered = new DistributorRegistered(TSTUUID, TSTDISTRIBUTOR);
        instance.handle(distributorRegistered);
        
        long expResult = originalCounter + 1;
        long result = instance.getCounters(TSTUUID);
        assertEquals(expResult, result);
    }


    /**
     * Test of getCounter method, of class DistributeurCounter.
     */
    @Test
    public void testCounterDecremented() {
        DistributeurCounter instance = new DistributeurCounter();

        long originalCounter = instance.getCounters(TSTUUID);
//        System.out.println("originalCounter:"+originalCounter+", UUID:"+TSTUUID);
        
        DistributorUnregistered distributorUnregistered = new DistributorUnregistered(TSTUUID, TSTDISTRIBUTOR);
        instance.handle(distributorUnregistered);
        
        long expResult = originalCounter - 1;
        long result = instance.getCounters(TSTUUID);
        assertEquals(expResult, result);
    }
    
}
