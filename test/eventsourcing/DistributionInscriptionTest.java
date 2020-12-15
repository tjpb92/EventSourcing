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
 * @version 0.1.1
 */
public class DistributionInscriptionTest {
    
    private static final UUID TSTUUID = UUID.randomUUID();
    
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
    
}
