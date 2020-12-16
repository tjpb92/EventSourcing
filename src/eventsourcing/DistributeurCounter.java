package eventsourcing;

import java.util.HashMap;
import java.util.UUID;

/**
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.5
 */
public class DistributeurCounter implements IEventHandler {

    private HashMap<UUID, Long> counters = new HashMap<>();

    public void handle(Event event) {
        Long counter;

        if (event instanceof DistributorRegistered) {
            counter = this.getCounters(event.getUuid());
//            System.out.println("counter:"+counter);
            counter++;
            counters.put(event.getUuid(), counter);
        } else if (event instanceof DistributorUnregistered) {
            counter = this.getCounters(event.getUuid());
            counter--;
            counters.put(event.getUuid(), counter);
        }
        
    }

    public long getCounters(UUID uuid) {
        return counters.getOrDefault(uuid, 0L);
    }

}
