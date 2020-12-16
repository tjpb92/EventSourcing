/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 */
public class DistributeurNameListTest {
    
    private static final UUID TSTUUID = UUID.randomUUID();
    private static final String TSTNAME = "totolito";
    private static final String TSTEMAIL = TSTNAME + "@mail.com";
    private static final Distributor TSTDISTRIBUTOR = new Distributor(TSTNAME, TSTEMAIL);

    public DistributeurNameListTest() {
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
     * Test of getNames method, of class DistributeurNameList.
     */
    @Test
    public void testDistributeurNameListRegistered() {
        UUID uuid = null;
        DistributeurNameList instance = new DistributeurNameList();
        ArrayList<String> names = instance.getNames(TSTUUID);
        long originalCounter = names.size();
        System.out.println("names(avant):"+names);
        
        DistributorRegistered distributorRegistered = new DistributorRegistered(TSTUUID, TSTDISTRIBUTOR);
        instance.handle(distributorRegistered);
        names = instance.getNames(TSTUUID);    
        long counter = names.size();
        System.out.println("names(après):"+names);
        assertEquals(counter, originalCounter+1);
    }

    /**
     * Test of getNames method, of class DistributeurNameList.
     */
    @Test
    public void testDistributeurNameListUnregistered() {
        UUID uuid = null;
        DistributeurNameList instance = new DistributeurNameList();
        ArrayList<String> names = instance.getNames(TSTUUID);
        long originalCounter = names.size();
        System.out.println("names(avant):"+names);
        
        DistributorRegistered distributorRegistered = new DistributorRegistered(TSTUUID, TSTDISTRIBUTOR);
        instance.handle(distributorRegistered);
        names = instance.getNames(TSTUUID);    
        long counter = names.size();
        System.out.println("names(interm):"+names);

        DistributorUnregistered distributorUnregistered = new DistributorUnregistered(TSTUUID, TSTDISTRIBUTOR);
        instance.handle(distributorUnregistered);
        names = instance.getNames(TSTUUID);    
        counter = names.size();
        System.out.println("names(après):"+names);
        assertEquals(counter, originalCounter);
    }
    
}
