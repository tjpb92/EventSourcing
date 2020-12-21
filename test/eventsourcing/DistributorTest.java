package eventsourcing;

import static eventsourcing.JeuxDEssais.DISTRIBUTOR_UUID;
import static eventsourcing.JeuxDEssais.EMAIL;
import static eventsourcing.JeuxDEssais.NAME;
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
 * @version 0.1.10
 */
public class DistributorTest {

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
    public void testDistributorGetUuid() {
        Distributor instance = new Distributor(DISTRIBUTOR_UUID, NAME, EMAIL);
        DistributorUuid expResult = DISTRIBUTOR_UUID;
        DistributorUuid result = instance.getUuid();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Distributor.
     */
    @Test
    public void testDistributorGetName() {
        Distributor instance = new Distributor(DISTRIBUTOR_UUID, NAME, EMAIL);
        String expResult = NAME;
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class Distributor.
     */
    @Test
    public void testDistributorGetEmail() {
        Distributor instance = new Distributor(DISTRIBUTOR_UUID, NAME, EMAIL);
        String expResult = EMAIL;
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Distributor.
     */
    @Test
    public void testDistributorToString() {
        Distributor instance = new Distributor(DISTRIBUTOR_UUID, NAME, EMAIL);
//        System.out.println(instance.toString());
        String expResult = "Distributor:{uuid:" + DISTRIBUTOR_UUID
                + ", name:" + NAME + ", email:" + EMAIL + "}";
//        System.out.println(expResult);
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
    public void testDistributorEquals() {
        Object obj = new Distributor(DISTRIBUTOR_UUID, NAME, EMAIL);
        Distributor instance = new Distributor(DISTRIBUTOR_UUID, NAME, EMAIL);
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Distributor's uuid cannot be null
     */
    @Test(expected = NullPointerException.class)
    public void testDistributorUuidCannotBeNull() {
        Object obj = new Distributor(null, NAME, EMAIL);
    }

    /**
     * Distributor's name cannot be null
     */
    @Test(expected = NullPointerException.class)
    public void testDistributorNameCannotBeNull() {
        Object obj = new Distributor(DISTRIBUTOR_UUID, null, EMAIL);
    }

    /**
     * Distributor's name cannot be empty
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDistributorNameCannotBeEmpty() {
        Object obj = new Distributor(DISTRIBUTOR_UUID, "", EMAIL);
    }

    /**
     * Distributor's email cannot be null
     */
    @Test(expected = NullPointerException.class)
    public void testDistributorEmailCannotBeNull() {
        Object obj = new Distributor(DISTRIBUTOR_UUID, NAME, null);
    }

    /**
     * Distributor's email cannot be empty
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDistributorEmailCannotBeEmpty() {
        Object obj = new Distributor(DISTRIBUTOR_UUID, NAME, "");
    }
}
