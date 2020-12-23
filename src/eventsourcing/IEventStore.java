package eventsourcing;

import java.util.ArrayList;

/**
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.12
 */
public interface IEventStore {
    
    public ArrayList<Event> get(DistributionInscriptionUuid aggregateUuid);
    public void save(ArrayList<Event> events);
    
}
