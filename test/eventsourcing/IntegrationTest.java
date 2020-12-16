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
public class IntegrationTest {

    private static final UUID TSTUUID = UUID.randomUUID();
    private static final String TSTNAME = "totolito";
    private static final String TSTEMAIL = TSTNAME + "@mail.com";
    private static final Distributor TSTDISTRIBUTOR = new Distributor(TSTNAME, TSTEMAIL);

    public IntegrationTest() {
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
    public void testDisplayUpdatedProjectionWhenSendCommand() {
        ArrayList<Event> eventStore = new ArrayList<>();
        EventBus eventBus = new EventBus(eventStore);
        ArrayList<Event> events = new ArrayList<>();

        DistributionInscription distributionInscription = new DistributionInscription(TSTUUID);

        Event inscriptionStarted = distributionInscription.startInscription(TSTUUID);
        events.add(inscriptionStarted);

        class TestEventHandler implements IEventHandler {

            public boolean called = false;

            public void handle(Event event) {
                this.called = true;
            }
        }
        TestEventHandler testReadModel = new TestEventHandler();
        eventBus.subscribe(testReadModel);

//        eventBus.publish(inscriptionStarted);
        eventBus.publish(events);

        assertEquals(testReadModel.called, true);
    }

    /**
     * Test of publish method, of class EventBus.
     */
    @Test
    public void testDisplayNotUpdatedProjectionWhenSendCommand() {
        ArrayList<Event> eventStore = new ArrayList<>();
        EventBus eventBus = new EventBus(eventStore);
        ArrayList<Event> events = new ArrayList<>();
        
        DistributionInscription distributionInscription = new DistributionInscription(TSTUUID);

        Event inscriptionStarted = distributionInscription.startInscription(TSTUUID);
        events.add(inscriptionStarted);

        class TestEventHandler implements IEventHandler {

            public boolean called = false;

            public void handle(Event event) {
                this.called = true;
            }
        }
        TestEventHandler testReadModel = new TestEventHandler();

//        eventBus.publish(inscriptionStarted);
        eventBus.publish(events);
        eventBus.subscribe(testReadModel);

        assertEquals(testReadModel.called, false);
    }

    /**
     * Test of publish method, of class EventBus.
     */
    @Test
    public void testDisplayUpdatedProjectionWhenMultipleSendCommand() {

        // Given
        ArrayList<Event> eventStore = new ArrayList<>();
        ArrayList<Event> events = new ArrayList<>();
        EventBus eventBus = new EventBus(eventStore);
        DistributeurCounter distributeurCounter = new DistributeurCounter();
        eventBus.subscribe(distributeurCounter);
        DistributeurNameList distributeurNameList = new DistributeurNameList();
        eventBus.subscribe(distributeurNameList);

        // When
        DistributionInscription distributionInscription = new DistributionInscription(TSTUUID);

        Event inscriptionStarted = distributionInscription.startInscription(TSTUUID);
//        eventBus.publish(inscriptionStarted);
        events.add(inscriptionStarted);

        Event distributorRegistered = distributionInscription.registerDistributor(TSTUUID, TSTDISTRIBUTOR);
//        eventBus.publish(distributorRegistered);
        events.add(distributorRegistered);
        eventBus.publish(events);

        // Then
        System.out.println("eventStore:" + eventStore);

//        assertEquals(testReadModel.called,2);
        assertEquals(distributeurCounter.getCounters(TSTUUID), 1);
        assertEquals(distributeurNameList.getNames(TSTUUID).size(), 1);
    }

}
