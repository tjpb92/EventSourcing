package eventsourcing;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Classe servant à tester le projet EventSourcing
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.5
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({eventsourcing.DistributionInscriptionTest.class,
    eventsourcing.DistributorTest.class, DistributeurCounter.class,
    DistributeurNameList.class, EventBus.class, IntegrationTest.class})
public class EventsourcingSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

}
