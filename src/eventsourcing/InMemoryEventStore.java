package eventsourcing;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.12
 */
public class InMemoryEventStore implements IEventStore {

    private final HashMap<DistributionInscriptionUuid, ArrayList<Event>> eventStore = new HashMap<>();

    @Override
    public ArrayList<Event> get(DistributionInscriptionUuid aggregateUuid) {
        return this.eventStore.getOrDefault(aggregateUuid, new ArrayList<>());
    }

    @Override
    public void save(ArrayList<Event> events) {
        ArrayList<Event> alreadyExitingEvents;

        for (Event event : events) {
            alreadyExitingEvents = this.get(event.getAggregateUuid());
            if ((alreadyExitingEvents.size() + 1) != event.getVersion()) {
                throw new IllegalArgumentException("Bad version for " + event);
            }
            alreadyExitingEvents.add(event);
            this.eventStore.put(event.getAggregateUuid(), alreadyExitingEvents);
        }
    }

}
