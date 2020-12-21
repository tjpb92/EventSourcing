package eventsourcing;

import static eventsourcing.JeuxDEssais.AGGREGATE_UUID;
import static eventsourcing.JeuxDEssais.AGGREGATE_UUID2;
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
public class IEventStoreTest {
    
    public IEventStoreTest() {
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
     * Test of ...
     */
    @Test
    public void testSaveSeveralAndGetOne() {
        ArrayList<Event> events = new ArrayList<>();
        ArrayList<Event> events2 = new ArrayList<>();
        ArrayList<Event> resultEvents;
        
        IEventStore instance = new InMemoryEventStore();
        
        DistributorRegistered distributorRegistered = new DistributorRegistered(AGGREGATE_UUID, 1, new DistributorAbstract(DISTRIBUTOR));
        events.add(distributorRegistered);        
        instance.save(events);
        
        DistributorRegistered distributorRegistered2 = new DistributorRegistered(AGGREGATE_UUID2, 1, new DistributorAbstract(DISTRIBUTOR));
        events2.add(distributorRegistered2);        
        instance.save(events2);
        
        resultEvents = instance.get(AGGREGATE_UUID);
        
        assertEquals(events, resultEvents);
        for(Event event:resultEvents) {
            assertEquals(AGGREGATE_UUID, event.getAggregateUuid());
        }
    
    }

    /**
     * Test of ...
     */
    @Test
    public void testSaveAndGet() {
        ArrayList<Event> events = new ArrayList<>();
        ArrayList<Event> resultEvents;
        
        IEventStore instance = new InMemoryEventStore();
        
        DistributorRegistered distributorRegistered = new DistributorRegistered(AGGREGATE_UUID, 1, new DistributorAbstract(DISTRIBUTOR));
        events.add(distributorRegistered);
        
        instance.save(events);
        resultEvents = instance.get(AGGREGATE_UUID);
        
        assertEquals(events, resultEvents);
        for(Event event:resultEvents) {
            assertEquals(AGGREGATE_UUID, event.getAggregateUuid());
        }
    
    }

    /**
     * Test of ...
     */
    @Test(expected = IllegalArgumentException.class)
    public void testThrowWrongXx() {
        ArrayList<Event> events = new ArrayList<>();
        
        IEventStore instance = new InMemoryEventStore();
        
        DistributorRegistered distributorRegistered = new DistributorRegistered(AGGREGATE_UUID, 0, new DistributorAbstract(DISTRIBUTOR));
        events.add(distributorRegistered);
        
        DistributorRegistered distributorRegistered2 = new DistributorRegistered(AGGREGATE_UUID, 0, new DistributorAbstract(DISTRIBUTOR));
        events.add(distributorRegistered2);
        
        instance.save(events);
    }
    
//    public class IEventStoreImpl implements IEventStore {
//
//        public ArrayList<Event> get(UUID uuid) {
//            return null;
//        }
//
//        public void save(ArrayList<Event> events) {
//        }
//    }
    
}
