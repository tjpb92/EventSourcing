package eventsourcing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.8
 */
public class InMemoryEventStore implements IEventStore {
    
    private HashMap<UUID, ArrayList<Event>> eventStore = new HashMap<>();    
 
        public ArrayList<Event> get(UUID uuid) {
            return this.eventStore.getOrDefault(uuid, new ArrayList<>());
        }

        public void save(ArrayList<Event> events) {
            ArrayList<Event> alreadyExitingEvents;
            
            for (Event event:events) {
                alreadyExitingEvents = this.get(event.getUuid());
                if ((alreadyExitingEvents.size()+1) != event.getVersion()) {
                    throw new IllegalArgumentException("Bad version for " + event);
                }
                alreadyExitingEvents.add(event);
                this.eventStore.put(event.getUuid(), alreadyExitingEvents);
            }
        }
    
}
