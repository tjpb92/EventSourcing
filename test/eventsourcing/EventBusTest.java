package eventsourcing;

import java.util.ArrayList;
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
public class EventBusTest {
    
    private static final UUID TSTUUID = UUID.randomUUID();
    private static final String TSTNAME = "totolito";
    private static final String TSTEMAIL = TSTNAME + "@mail.com";
    private static final Distributor TSTDISTRIBUTOR = new Distributor(TSTNAME, TSTEMAIL);
    
    public EventBusTest() {
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
     * Test of publish method, of class EventBus.
     */
    @Test
    public void testStoreEventOnPublish() {
        DistributorRegistered distributorRegistered = new DistributorRegistered(TSTUUID, TSTDISTRIBUTOR);
        ArrayList<Event> eventStore = new ArrayList<>();
        ArrayList<Event> events = new ArrayList<>();

        EventBus instance = new EventBus(eventStore);
        events.add(distributorRegistered);
        
//        instance.publish(distributorRegistered);
        instance.publish(events);
        
        assertEquals(eventStore.size(), 1);
    }

    /**
     * Test of publish method, of class EventBus.
     */
    @Test
    public void testHandlerCalledOnPublish() {
        ArrayList<Event> events = new ArrayList<>();
        DistributorRegistered distributorRegistered = new DistributorRegistered(TSTUUID, TSTDISTRIBUTOR);
        events.add(distributorRegistered);
        ArrayList<Event> eventStore = new ArrayList<>();

        EventBus instance = new EventBus(eventStore);
        
        class TestEventHandler implements IEventHandler {
            public boolean called = false;
            
            public void handle(Event event) {
                this.called=true;
            }
        }
        TestEventHandler testReadModel = new TestEventHandler();
        instance.subscribe(testReadModel);
        
//        instance.publish(distributorRegistered);
        instance.publish(events);
        
        assertEquals(testReadModel.called,true);
    }
    
}
