package eventsourcing;

import static eventsourcing.JeuxDEssais.AGGREGATE_UUID;
import static eventsourcing.JeuxDEssais.DISTRIBUTOR;
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
 * @version 0.1.10
 */
public class DistributionInscriptionTest {

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
        Object obj = new DistributionInscription(null);
    }

    /**
     * Test InscriptionStarted event
     */
    @Test
    public void testInscriptionStarted() {

        InscriptionStarted expectedResult = new InscriptionStarted(AGGREGATE_UUID);

        DistributionInscription distributionInscription = new DistributionInscription(AGGREGATE_UUID);
        InscriptionStarted result = distributionInscription.startInscription(AGGREGATE_UUID);

        assertEquals(expectedResult, result);
    }

    /**
     * Test cannot perform two consecutive startInscription() command with the same aggregate
     */
    @Test
    public void testCannotPerformTwoStartInscriptionCommand() {

        DistributionInscription distributionInscription = new DistributionInscription(AGGREGATE_UUID);
        InscriptionStarted firstInscriptionStarted = distributionInscription.startInscription(AGGREGATE_UUID);

        InscriptionStarted nextInscriptionStarted = distributionInscription.startInscription(AGGREGATE_UUID);

        assertNotNull(firstInscriptionStarted);
        assertNull(nextInscriptionStarted);
    }

    /**
     * Test cannot perform two consecutive registerDistributor() command with 
     * the same distributor on the same aggregate
     */
    @Test
    public void testCannotPerformTwoRegisterDistributorCommand() {

        DistributionInscription distributionInscription = new DistributionInscription(AGGREGATE_UUID);
        InscriptionStarted firstInscriptionStarted = distributionInscription.startInscription(AGGREGATE_UUID);
        DistributorAbstract distributorAbstract = new DistributorAbstract(DISTRIBUTOR);
        DistributorRegistered firstDistributorRegistered = distributionInscription.registerDistributor(AGGREGATE_UUID, distributorAbstract);

        DistributorRegistered nextDistributorRegistered = distributionInscription.registerDistributor(AGGREGATE_UUID, distributorAbstract);

        assertNotNull("Event should be not null", firstDistributorRegistered);
        assertNull("Event should be null", nextDistributorRegistered);
    }

    /**
     * Test cannot perform two consecutive unregisterDistributor() command with 
     * the same distributor on the same aggregate
     */
    @Test
    public void testCannotPerformTwoUnregisterDistributorCommand() {

        DistributionInscription distributionInscription = new DistributionInscription(AGGREGATE_UUID);
        InscriptionStarted firstInscriptionStarted = distributionInscription.startInscription(AGGREGATE_UUID);
        DistributorAbstract distributorAbstract = new DistributorAbstract(DISTRIBUTOR);
        
        DistributorUnregistered firstDistributorUnregistered = distributionInscription.unregisterDistributor(AGGREGATE_UUID, distributorAbstract);

        DistributorUnregistered nextDistributorUnregistered = distributionInscription.unregisterDistributor(AGGREGATE_UUID, distributorAbstract);

        assertNotNull("Event should be not null", firstDistributorUnregistered);
        assertNull("Event should be null", nextDistributorUnregistered);
    }

    /**
     * Test DistributorRegistered event
     */
    @Test
    public void testDistributorRegistered() {

        DistributorRegistered expectedResult = new DistributorRegistered(AGGREGATE_UUID, 1, new DistributorAbstract(DISTRIBUTOR));
        
        DistributionInscription distributionInscription = new DistributionInscription(AGGREGATE_UUID);
        InscriptionStarted firstInscriptionStarted = distributionInscription.startInscription(AGGREGATE_UUID);
        DistributorRegistered result = distributionInscription.registerDistributor(AGGREGATE_UUID, new DistributorAbstract(DISTRIBUTOR));

        assertEquals(expectedResult, result);
    }

    /**
     * Test cannot registerDistributor if inscription is not started
     */
    @Test
    public void testCannotRegisterDistributorIfInscriptionNtStarted() {

        DistributionInscription distributionInscription = new DistributionInscription(AGGREGATE_UUID);
        DistributorRegistered result = distributionInscription.registerDistributor(AGGREGATE_UUID, new DistributorAbstract(DISTRIBUTOR));
        assertNull("Event should be null", result);
    }

    /**
     * Test DistributorUnregistered event
     * TODO : à revoir
     */
    @Test
    public void testDistributorUnregistered() {

        DistributorUnregistered expectedResult = new DistributorUnregistered(AGGREGATE_UUID, 1, new DistributorAbstract(DISTRIBUTOR));
        System.out.println("expectedResult:"+expectedResult.getVersion());
        
        DistributionInscription distributionInscription = new DistributionInscription(AGGREGATE_UUID);
        InscriptionStarted firstInscriptionStarted = distributionInscription.startInscription(AGGREGATE_UUID);
        DistributorUnregistered result = distributionInscription.unregisterDistributor(AGGREGATE_UUID, new DistributorAbstract(DISTRIBUTOR));
        System.out.println("result:"+result.getVersion());

        assertEquals(expectedResult, result);
    }
}
