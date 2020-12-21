package eventsourcing;

import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe pour tester DistributionInscriptionUuid
 *
 * @author Thierry Baribaud
 * @version 0.1.11
 */
public class DistributionInscriptionUuidTest {

    public DistributionInscriptionUuidTest() {
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
     * Test from a real UUID
     */
    @Test
    public void testFromRealUuid() {
        UUID uuid = UUID.randomUUID();
//        System.out.println("uuid:" + uuid);
        
        String expResult = uuid.toString();
        DistributionInscriptionUuid result = new DistributionInscriptionUuid(uuid);
//        System.out.println("result:" + result);

        assertEquals(expResult, result.toString());
    }

//    /**
//     * Test from a null UUID
//     */
//    @Test(expected = NullPointerException.class)
//    public void testFromANullUUID() {
//        UUID badUuid = null;
////        System.out.println("badUuid:" + badUuid);
//        
//        DistributionInscriptionUuid result = new DistributionInscriptionUuid(badUuid);
//    }

    /**
     * Test from a string representing an UUID
     */
    @Test
    public void testFromAUUIDString() {
        UUID uuid = UUID.randomUUID();
//        System.out.println("uuid:" + uuid);
        
        String expResult = uuid.toString();
        DistributionInscriptionUuid result = new DistributionInscriptionUuid(uuid.toString());
//        System.out.println("result:" + result);

        assertEquals(expResult, result.toString());
    }

    /**
     * Test from a string representing a bad UUID
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFromABadUUIDString() {
        String badUuid = "bd2c_cd6-2018-470e-830f-b730b43aa1f9";
//        System.out.println("badUuid:" + badUuid);
        
        DistributionInscriptionUuid result = new DistributionInscriptionUuid(badUuid);
    }

    /**
     * Test from a null UUID string
     */
    @Test(expected = NullPointerException.class)
    public void testFromANullUUIDString() {
        String badUuid = null;
//        System.out.println("badUuid:" + badUuid);
        
        DistributionInscriptionUuid result = new DistributionInscriptionUuid(badUuid);
    }

    /**
     * Test from a random UUID generator
     */
    @Test
    public void testFromARandomUUIDGenerator() {
        
        DistributionInscriptionUuid expResult = new DistributionInscriptionUuid();
        UUID result = UUID.fromString(expResult.toString());

        assertEquals(expResult.toString(), result.toString());
    }
}
