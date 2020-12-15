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
 * @version 0.1.2
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

        assertEquals(expectedResult, result);
    }

    /**
     * Test DistributorRegistered event
     */
    @Test
    public void testDistributorRegistered() {
        System.out.println("distributorRegistered");

        DistributorRegistered expectedResult = new DistributorRegistered(TSTUUID, TSTDISTRIBUTOR);
        System.out.println("expectedResult:" + expectedResult);

        DistributionInscription distributionInscription = new DistributionInscription(TSTUUID);
        DistributorRegistered result = distributionInscription.registerDistributor(TSTUUID, TSTDISTRIBUTOR);
        System.out.println("result:" + result);

        assertEquals(expectedResult, result);
    }

    /**
     * Test Distributorunregistered event
     */
    @Test
    public void testDistributorUnregistered() {
        System.out.println("distributorUnregistered");

        DistributorUnregistered expectedResult = new DistributorUnregistered(TSTUUID, TSTDISTRIBUTOR);
        System.out.println("expectedResult:" + expectedResult);

        DistributionInscription distributionInscription = new DistributionInscription(TSTUUID);
        DistributorUnregistered result = distributionInscription.unregisterDistributor(TSTUUID, TSTDISTRIBUTOR);
        System.out.println("result:" + result);

        assertEquals(expectedResult, result);
    }
}
