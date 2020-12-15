package eventsourcing;

import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe pour tester un distributeur
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.2
 */
public class DistributorTest {

    private static final UUID TSTUUID = UUID.randomUUID();
    private static final String TSTNAME = "totolito";
    private static final String TSTEMAIL = TSTNAME + "@mail.com";

    public DistributorTest() {
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
     * Test of getUuid method, of class Distributor.
     */
    @Test
    public void testGetUuid() {
        System.out.println("getUuid");
        Distributor instance = new Distributor(TSTUUID, TSTNAME, TSTEMAIL);
        UUID expResult = TSTUUID;
        UUID result = instance.getUuid();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Distributor.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Distributor instance = new Distributor(TSTUUID, TSTNAME, TSTEMAIL);
        String expResult = TSTNAME;
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class Distributor.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Distributor instance = new Distributor(TSTUUID, TSTNAME, TSTEMAIL);
        String expResult = TSTEMAIL;
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Distributor.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Distributor instance = new Distributor(TSTUUID, TSTNAME, TSTEMAIL);
//        System.out.println(instance);
        String expResult = "Distributor{uuid=" + TSTUUID
                + ", name=" + TSTNAME + ", email=" + TSTEMAIL + "}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Distributor.
     */
//    @Test
//    public void testHashCode() {
//        System.out.println("hashCode");
//        Distributor instance = null;
//        int expResult = 0;
//        int result = instance.hashCode();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of equals method, of class Distributor.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new Distributor(TSTUUID, TSTNAME, TSTEMAIL);
        Distributor instance = new Distributor(TSTUUID, TSTNAME, TSTEMAIL);
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Distributor's uuid cannot be null
     */
    @Test(expected = NullPointerException.class)
    public void testDistributorUuidCannotBeNull() {
        System.out.println("Distributor's uuid cannot be null");
        Object obj = new Distributor(null, TSTNAME, TSTEMAIL);
    }

    /**
     * Distributor's name cannot be null
     */
    @Test(expected = NullPointerException.class)
    public void testDistributorNameCannotBeNull() {
        System.out.println("Distributor's name cannot be null");
        Object obj = new Distributor(TSTUUID, null, TSTEMAIL);
    }

    /**
     * Distributor's name cannot be empty
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDistributorNameCannotBeEmpty() {
        System.out.println("Distributor's name cannot be empty");
        Object obj = new Distributor(TSTUUID, "", TSTEMAIL);
    }

    /**
     * Distributor's email cannot be null
     */
    @Test(expected = NullPointerException.class)
    public void testDistributorEmailCannotBeNull() {
        System.out.println("Distributor's email cannot be null");
        Object obj = new Distributor(TSTUUID, TSTNAME, null);
    }

    /**
     * Distributor's email cannot be empty
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDistributorEmailCannotBeEmpty() {
        System.out.println("Distributor's email cannot be empty");
        Object obj = new Distributor(TSTUUID, TSTNAME, "");
    }
}
