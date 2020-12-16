package eventsourcing;

import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe pour tester l'agrégat DistributionInscription
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.4
 */
public class DistributionInscriptionTest {

    private static final UUID TSTUUID = UUID.randomUUID();
    private static final String TSTNAME = "totolito";
    private static final String TSTEMAIL = TSTNAME + "@mail.com";
    private static final Distributor TSTDISTRIBUTOR = new Distributor(TSTNAME, TSTEMAIL);

    public DistributionInscriptionTest() {
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
     * Aggregate's uuid cannot be null
     */
    @Test(expected = NullPointerException.class)
    public void testDistributionInscriptionUuidCannotBeNull() {
        System.out.println("DistributionInscription's uuid cannot be null");
        Object obj = new DistributionInscription(null);
    }

    /**
     * Test InscriptionStarted event
     */
    @Test
    public void testInscriptionStarted() {
        System.out.println("inscriptionStarted");

        InscriptionStarted expectedResult = new InscriptionStarted(TSTUUID);
        System.out.println("expectedResult:" + expectedResult);

        DistributionInscription distributionInscription = new DistributionInscription(TSTUUID);
        InscriptionStarted result = distributionInscription.startInscription(TSTUUID);
        System.out.println("result:" + result);
        System.out.println("distributionInscription:" + distributionInscription);

        assertEquals(expectedResult, result);
    }

    /**
     * Test cannot perform two consecutive startInscription() command with the same aggregate
     */
    @Test
    public void testCannotPerformTwoStartInscriptionCommand() {
        System.out.println("cannotPerformTwoStartInscriptionCommand");

        DistributionInscription distributionInscription = new DistributionInscription(TSTUUID);
        InscriptionStarted firstInscriptionStarted = distributionInscription.startInscription(TSTUUID);

        InscriptionStarted nextInscriptionStarted = distributionInscription.startInscription(TSTUUID);

        assertNotNull(firstInscriptionStarted);
        assertNull(nextInscriptionStarted);
    }

    /**
     * Test cannot perform two consecutive registerDistributor() command with 
     * the same distributor on the same aggregate
     */
    @Test
    public void testCannotPerformTwoRegisterDistributorCommand() {
        System.out.println("cannotPerformTwoRegisterDistributorCommand");

        DistributionInscription distributionInscription = new DistributionInscription(TSTUUID);
        InscriptionStarted firstInscriptionStarted = distributionInscription.startInscription(TSTUUID);
        DistributorRegistered firstDistributorRegistered = distributionInscription.registerDistributor(TSTUUID, TSTDISTRIBUTOR);

        DistributorRegistered nextDistributorRegistered = distributionInscription.registerDistributor(TSTUUID, TSTDISTRIBUTOR);

        assertNotNull("Event should be not null", firstDistributorRegistered);
        assertNull("Event should be null", nextDistributorRegistered);
    }

    /**
     * Test cannot perform two consecutive unregisterDistributor() command with 
     * the same distributor on the same aggregate
     */
    @Test
    public void testCannotPerformTwoUnregisterDistributorCommand() {
        System.out.println("cannotPerformTwoUnregisterDistributorCommand");

        DistributionInscription distributionInscription = new DistributionInscription(TSTUUID);
        InscriptionStarted firstInscriptionStarted = distributionInscription.startInscription(TSTUUID);
        
        DistributorUnregistered firstDistributorUnregistered = distributionInscription.unregisterDistributor(TSTUUID, TSTDISTRIBUTOR);

        DistributorUnregistered nextDistributorUnregistered = distributionInscription.unregisterDistributor(TSTUUID, TSTDISTRIBUTOR);

        assertNotNull("Event should be not null", firstDistributorUnregistered);
        assertNull("Event should be null", nextDistributorUnregistered);
    }

    /**
     * Test DistributorRegistered event
     */
    @Test
    public void testDistributorRegistered() {
        System.out.println("distributorRegistered");

        DistributorRegistered expectedResult = new DistributorRegistered(TSTUUID, TSTDISTRIBUTOR);
        
        DistributionInscription distributionInscription = new DistributionInscription(TSTUUID);
        InscriptionStarted firstInscriptionStarted = distributionInscription.startInscription(TSTUUID);
        DistributorRegistered result = distributionInscription.registerDistributor(TSTUUID, TSTDISTRIBUTOR);

        assertEquals(expectedResult, result);
    }

    /**
     * Test cannot registerDistributor if inscription is not started
     */
    @Test
    public void testCannotRegisterDistributorIfInscriptionNtStarted() {
        System.out.println("cannotRegisterDistributorIfInscriptionNtStarted");

        DistributionInscription distributionInscription = new DistributionInscription(TSTUUID);
        DistributorRegistered result = distributionInscription.registerDistributor(TSTUUID, TSTDISTRIBUTOR);
        assertNull("Event should be null", result);
    }

    /**
     * Test DistributorUnregistered event
     */
    @Test
    public void testDistributorUnregistered() {
        System.out.println("distributorUnregistered");

        DistributorUnregistered expectedResult = new DistributorUnregistered(TSTUUID, TSTDISTRIBUTOR);

        DistributionInscription distributionInscription = new DistributionInscription(TSTUUID);
        InscriptionStarted firstInscriptionStarted = distributionInscription.startInscription(TSTUUID);
        DistributorUnregistered result = distributionInscription.unregisterDistributor(TSTUUID, TSTDISTRIBUTOR);

        assertEquals(expectedResult, result);
    }
}
