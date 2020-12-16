package eventsourcing;

import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class pour tester DistributorUuid
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.6
 */
public class DistributorUuidTest {

    private final static UUID TSTUUID = UUID.fromString("8faf332e-68e6-4bda-b02a-59f610639575");

    public DistributorUuidTest() {
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
     * Test toString() method
     */
    @Test
    public void testDistributorUuidToString() {
        String expResult = TSTUUID.toString();
        DistributorUuid instance = new DistributorUuid(TSTUUID);

        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
