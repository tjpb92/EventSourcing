package eventsourcing;

import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.8
 */
public interface IEventStore {
    
    public ArrayList<Event> get(UUID uuid);
    public void save(ArrayList<Event> events);
    
}
