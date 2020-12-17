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
 * @version 0.1.7
 */
public class EventBusTest {

    private static final UUID AGGREGATE_UUID = UUID.randomUUID();
    private static final String NAME = "totolito";
    private static final String EMAIL = NAME + "@mail.com";
    private static final Distributor DISTRIBUTOR = new Distributor(NAME, EMAIL);

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
        DistributorRegistered distributorRegistered = new DistributorRegistered(AGGREGATE_UUID, new DistributorAbstract(DISTRIBUTOR));
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
        DistributorRegistered distributorRegistered = new DistributorRegistered(AGGREGATE_UUID, new DistributorAbstract(DISTRIBUTOR));
        events.add(distributorRegistered);
        ArrayList<Event> eventStore = new ArrayList<>();

        EventBus instance = new EventBus(eventStore);

        class TestEventHandler implements IEventHandler {

            public boolean called = false;

            @Override
            public void handle(Event event) {
                this.called = true;
            }
        }
        TestEventHandler testReadModel = new TestEventHandler();
        instance.subscribe(testReadModel);

//        instance.publish(distributorRegistered);
        instance.publish(events);

        assertEquals(testReadModel.called, true);
    }

}
