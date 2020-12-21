package eventsourcing;

import java.util.HashMap;
import java.util.UUID;

/**
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.9
 */
public class DistributeurCounter implements IEventHandler {

    private final HashMap<UUID, Long> counters = new HashMap<>();

    @Override
    public void handle(Event event) {
        Long counter;

        if (event instanceof DistributorRegistered) {
            counter = this.getCounters(event.getAggregateUuid());
//            System.out.println("counter:"+counter);
            counter++;
            counters.put(event.getAggregateUuid(), counter);
        } else if (event instanceof DistributorUnregistered) {
            counter = this.getCounters(event.getAggregateUuid());
            counter--;
            counters.put(event.getAggregateUuid(), counter);
        }
        
    }

    public long getCounters(UUID uuid) {
        return counters.getOrDefault(uuid, 0L);
    }

}
