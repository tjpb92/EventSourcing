package eventsourcing;

import static eventsourcing.JeuxDEssais.AGGREGATE_UUID;
import static eventsourcing.JeuxDEssais.DISTRIBUTOR;
import java.util.ArrayList;
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
 * @version 0.1.10
 */
public class DistributeurNameListTest {
    
    public DistributeurNameListTest() {
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
     * Test of getNames method, of class DistributeurNameList.
     */
    @Test
    public void testDistributeurNameListRegistered() {
        DistributeurNameList instance = new DistributeurNameList();
        ArrayList<String> names = instance.getNames(AGGREGATE_UUID);
        long originalCounter = names.size();
        
        DistributorRegistered distributorRegistered = new DistributorRegistered(AGGREGATE_UUID, 0, new DistributorAbstract(DISTRIBUTOR));
        instance.handle(distributorRegistered);
        names = instance.getNames(AGGREGATE_UUID);    
        long counter = names.size();
        assertEquals(counter, originalCounter+1);
    }

    /**
     * Test of getNames method, of class DistributeurNameList.
     */
    @Test
    public void testDistributeurNameListUnregistered() {
        DistributeurNameList instance = new DistributeurNameList();
        ArrayList<String> names = instance.getNames(AGGREGATE_UUID);
        long originalCounter = names.size();
        
        DistributorRegistered distributorRegistered = new DistributorRegistered(AGGREGATE_UUID, 0, new DistributorAbstract(DISTRIBUTOR));
        instance.handle(distributorRegistered);
        names = instance.getNames(AGGREGATE_UUID);    
        long counter = names.size();

        DistributorUnregistered distributorUnregistered = new DistributorUnregistered(AGGREGATE_UUID, 1, new DistributorAbstract(DISTRIBUTOR));
        instance.handle(distributorUnregistered);
        names = instance.getNames(AGGREGATE_UUID);    
        counter = names.size();
        assertEquals(counter, originalCounter);
    }
    
}
